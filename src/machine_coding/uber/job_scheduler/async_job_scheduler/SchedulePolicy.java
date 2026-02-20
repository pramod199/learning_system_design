package machine_coding.uber.job_scheduler.async_job_scheduler;

public interface SchedulePolicy {
    long computeNextRunTime();
    boolean isRecurring();
}
