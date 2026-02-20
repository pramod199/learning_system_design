package machine_coding.uber.job_scheduler.async_job_scheduler;

public enum TaskStatus {
    SCHEDULED,
    WAITING_FOR_DEPENDENCY,
    RUNNING,
    COMPLETED,
    FAILED,

    CANCELLED
}
