package machine_coding.uber.job_scheduler.async_job_scheduler;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ScheduledTask implements Comparable<ScheduledTask> {
    String id;
    Task task;
    SchedulePolicy policy;

    volatile long nextRunTime;
    volatile TaskStatus status = TaskStatus.SCHEDULED;

    Set<String> dependencies = ConcurrentHashMap.newKeySet();
    Set<String> dependents = ConcurrentHashMap.newKeySet();

    public ScheduledTask(String id, Task task, SchedulePolicy policy, long nextRunTime) {
        this.id = id;
        this.task = task;
        this.policy = policy;
        this.nextRunTime = nextRunTime;
    }

    boolean isRecurring() {
        return policy.isRecurring();
    }

    @Override
    public int compareTo(ScheduledTask o) {
        return Long.compare(this.nextRunTime, o.nextRunTime);
    }
}
