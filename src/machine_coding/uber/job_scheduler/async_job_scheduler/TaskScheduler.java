package machine_coding.uber.job_scheduler.async_job_scheduler;

class TaskScheduler implements  ITaskScheduler {

    private final SchedulerEngine engine;

    public TaskScheduler(int workers) {
        this.engine = new SchedulerEngine(workers);
    }

    public String schedule(TaskSpec spec) {
        return engine.schedule(spec);
    }

    public boolean cancel(String id) {
        return engine.cancel(id);
    }

    public void shutdown() {
        engine.shutdown();
    }
}