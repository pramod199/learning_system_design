package machine_coding.uber.job_scheduler.job_sch_youtube;

public class TaskSchedulerImpl implements ITaskScheduler {
    SchedulerEngine schedulerEngine;

    public TaskSchedulerImpl(int workerThread) {
        this.schedulerEngine = new SchedulerEngine(workerThread);
    }

    @Override
    public String schedule(TaskSpec spec) {
        return schedulerEngine.schedule(spec);
    }

    @Override
    public boolean cancel(String tId) {
        return schedulerEngine.cancel(tId);
    }

    @Override
    public void shutDown() {
        schedulerEngine.shutDown();
    }
}
