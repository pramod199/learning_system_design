package machine_coding.uber.job_scheduler.async_job_scheduler;

public class OneTimePolicy implements SchedulePolicy {
    long runAt;

    public OneTimePolicy(long runAt) {
        this.runAt = runAt;
    }

    @Override
    public long computeNextRunTime() {
        return runAt;
    }

    @Override
    public boolean isRecurring() {
        return false;
    }
}
