package machine_coding.uber.job_scheduler.job_sch_youtube;

public interface ISchedulePolicy {
    long getNextExecutionTime();
    boolean isRecurring();
}
