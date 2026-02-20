package machine_coding.uber.job_scheduler.async_job_scheduler;

public class FixedDelayPolicy implements SchedulePolicy {
    long intervalMs;

    public FixedDelayPolicy(long intervalMs) {
        this.intervalMs = intervalMs;
    }

    @Override
    public long computeNextRunTime() {
        return System.currentTimeMillis() + intervalMs;
    }

    @Override
    public boolean isRecurring() {
        return true;
    }


}
