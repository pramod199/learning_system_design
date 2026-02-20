package machine_coding.uber.job_scheduler.async_job_scheduler;

/*
Command design pattern
 */
public interface Task {
    void execute() throws Exception;
}
