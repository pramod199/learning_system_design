package machine_coding.uber.job_scheduler.job_sch_youtube;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class ScheduledTask implements Comparable<ScheduledTask> {
    String id;
    Task task;
    ISchedulePolicy schedulePolicy;

    volatile long nextRuntime;

    volatile TaskStatus status;

    Set<String> dependents = ConcurrentHashMap.newKeySet(); // child
    Set<String> dependencies = ConcurrentHashMap.newKeySet(); // parent

    public ScheduledTask(Task task, ISchedulePolicy schedulePolicy, long nextRuntime) {
        this.id = UUID.randomUUID().toString();
        this.task = task;
        this.schedulePolicy = schedulePolicy;
        this.nextRuntime = nextRuntime;
    }

    public  boolean isRucurring(){
        return schedulePolicy.isRecurring();
    }


    @Override
    public int compareTo(ScheduledTask o) {
        return Long.compare(this.nextRuntime, o.nextRuntime);
    }
}
