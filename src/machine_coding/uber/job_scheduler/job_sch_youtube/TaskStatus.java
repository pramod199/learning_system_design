package machine_coding.uber.job_scheduler.job_sch_youtube;

public enum TaskStatus {
    SCHEDULED,
    WAITING_FOR_DEPENDENCY,
    RUNNING,
    FINISHED,
    CANCELLED,
    FAILED
}
