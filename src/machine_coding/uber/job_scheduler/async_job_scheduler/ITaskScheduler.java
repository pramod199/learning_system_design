package machine_coding.uber.job_scheduler.async_job_scheduler;

/*
can have implementation like

InMemoryTaskScheduler
DistributedTaskScheduler
PersistentTaskScheduler
CronTaskScheduler
 */
public interface ITaskScheduler {
    String schedule(TaskSpec spec);

    boolean cancel(String taskId);

    void shutdown();
}
