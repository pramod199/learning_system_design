package machine_coding.uber.job_scheduler.async_job_scheduler;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

public class SchedulerEngine {
    PriorityBlockingQueue<ScheduledTask> queue = new PriorityBlockingQueue<>();
    Map<String, ScheduledTask> tasks = new ConcurrentHashMap<>(); // this is to support cancel of tasks

    ExecutorService workers;

    volatile boolean running = true;

    public SchedulerEngine(int workerThreads) {
        workers = Executors.newFixedThreadPool(workerThreads);
        startDispatcher();
    }

    private void startDispatcher() {
        Thread dispatcher = new Thread(() -> {
            while (running) {
                try {
                    ScheduledTask t = queue.take();
                    long now = System.currentTimeMillis();

                    if (t.status == TaskStatus.CANCELLED)
                        continue;

                    if (t.nextRunTime > now) {
                        queue.offer(t);
                        Thread.sleep(Math.min(100, t.nextRunTime - now));
                        continue;
                    }

                    if (!t.dependencies.isEmpty()) { // simple check
                        t.status = TaskStatus.WAITING_FOR_DEPENDENCY;
                        continue;
                    }

                    workers.submit(() -> runTask(t));
                } catch (InterruptedException ex) {
                    System.out.println("got interrupted exception");
                }
            }
        });
        dispatcher.setDaemon(true);
        dispatcher.start();
    }

    private void runTask(ScheduledTask t) {
        if (t.status == TaskStatus.CANCELLED) {
            System.out.println("task cancelled: " + t.id);
            return;
        }

        t.status = TaskStatus.RUNNING;

        try {
            t.task.execute();
            t.status = TaskStatus.COMPLETED;
        } catch (Exception e) {
            t.status = TaskStatus.FAILED;
        }

        // release dependents
        for (String childId : t.dependents) {
            ScheduledTask child = tasks.get(childId);
            child.dependencies.remove(t.id);

            if (child.dependencies.isEmpty() && child.status == TaskStatus.WAITING_FOR_DEPENDENCY) {
                child.status = TaskStatus.SCHEDULED;
                child.nextRunTime = child.policy.computeNextRunTime();
                queue.offer(child);
            }
        }

        // recurring
        if (t.isRecurring() && t.status != TaskStatus.CANCELLED) {
            t.nextRunTime = t.policy.computeNextRunTime();
            t.status = TaskStatus.SCHEDULED;
            queue.offer(t);
        }
    }

    // api used by task scheduler
    String schedule(TaskSpec spec) {
        String id = UUID.randomUUID().toString();

        long next = spec.policy.computeNextRunTime();
        ScheduledTask t = new ScheduledTask(id, spec.task, spec.policy, next);

        tasks.put(id, t);
        for (String depId : spec.dependencies) {
            ScheduledTask parent = tasks.get(depId);
            if (parent == null) {
                throw new DependencyNotFoundException("Dependency task not found: " + depId);
            }
            t.dependencies.add(depId);
            parent.dependents.add(id);
            t.status = TaskStatus.WAITING_FOR_DEPENDENCY;
        }

        queue.offer(t);
        return id;
    }

    boolean cancel(String id) {
        ScheduledTask t = tasks.get(id);
        if (t == null) {
            return false;
        }

        if (t.status == TaskStatus.SCHEDULED || t.status == TaskStatus.WAITING_FOR_DEPENDENCY) {
            t.status = TaskStatus.CANCELLED;
            return true;
        }
        return false;
    }

    void shutdown() {
        running = false;
        workers.shutdownNow();
    }
}
