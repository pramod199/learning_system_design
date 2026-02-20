package machine_coding.uber.job_scheduler.job_sch_youtube;

public interface ITaskScheduler {
    String schedule(TaskSpec spec);
    boolean cancel(String tId);
    void shutDown();
}
