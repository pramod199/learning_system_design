package machine_coding.uber.job_scheduler.job_sch_youtube;

import java.util.Map;
import java.util.concurrent.*;

public class SchedulerEngine {
    PriorityBlockingQueue<ScheduledTask> queue = new PriorityBlockingQueue<>();
    Map<String, ScheduledTask> tasks = new ConcurrentHashMap<>();
    ExecutorService workers;

    volatile boolean running = true;

    public SchedulerEngine(int workerThread) {
        workers = Executors.newFixedThreadPool(workerThread);
        startDispatcher();
    }

    private void startDispatcher() {
        Thread dispatcher = new Thread(() -> {
            while (running) {
                try {
                    ScheduledTask task = queue.take();
                    long nextRuntime = task.nextRuntime;
                    long now = System.currentTimeMillis();
                    if (task.status == TaskStatus.CANCELLED) {
                        System.out.println("task cancelled: " + task.id);
                        continue;
                    }

                    if (nextRuntime > now) {
                        // still time did not come.
                        queue.offer(task);
                        Thread.sleep(Math.min(100, nextRuntime - now));
                        continue;
                    }

                    if (!task.dependencies.isEmpty()) {
                        task.status = TaskStatus.WAITING_FOR_DEPENDENCY;
                        continue;
                    }
                    workers.submit(() -> runTask(task));
                } catch (InterruptedException e) {
                    System.out.println("interrupted Io exception, ignored");

                }
            }

        });
        dispatcher.start();
    }

    private void runTask(ScheduledTask t) {
        if (t.status == TaskStatus.CANCELLED) {
            return;
        }

        t.status = TaskStatus.RUNNING;
        try {
            t.task.execute();
            t.status = TaskStatus.FINISHED;
        } catch (Exception e){
            t.status = TaskStatus.FAILED;
        }

        // release dependents
        for (String dependent : t.dependents) {
            ScheduledTask child = tasks.get(dependent);
            child.dependencies.remove(t.id);

            if (child.dependencies.isEmpty() && child.status == TaskStatus.WAITING_FOR_DEPENDENCY) {
                child.status = TaskStatus.SCHEDULED;
                child.nextRuntime = child.schedulePolicy.getNextExecutionTime();
                queue.offer(child);
            }
        }

        // recurring task
        if (t.isRucurring() && t.status != TaskStatus.CANCELLED){
            t.nextRuntime = t.schedulePolicy.getNextExecutionTime();
            t.status = TaskStatus.SCHEDULED;
            queue.offer(t);
        }

    }

    // api used by task scheduler
    public String schedule(TaskSpec spec) {
        long next = spec.policy.getNextExecutionTime();
        ScheduledTask task = new ScheduledTask(spec.task, spec.policy, next);

        tasks.put(task.id, task);

        for (String dependency : spec.dependencies) {
            ScheduledTask parent = tasks.get(dependency);
            if (parent == null) {
                throw new DependencyNotFoundException("parent missing");
            }

            if (parent.status == TaskStatus.FINISHED) {
                continue;
            }
            if (parent.status == TaskStatus.FAILED || parent.status == TaskStatus.CANCELLED) {
                task.status = TaskStatus.FAILED;
                return task.id;
            }
            task.dependencies.add(parent.id);
            parent.dependents.add(task.id);
            task.status = TaskStatus.WAITING_FOR_DEPENDENCY;
        }

        queue.offer(task);
        return task.id;
    }

    public boolean cancel(String id) {
        ScheduledTask task = tasks.get(id);

        if (task == null){
            return false;
        }

        if (task.status == TaskStatus.SCHEDULED || task.status == TaskStatus.WAITING_FOR_DEPENDENCY){
            task.status = TaskStatus.CANCELLED;
            return true;
        }
        return false;
    }

    public void shutDown(){
        running = false;
        workers.shutdownNow();
    }

}
