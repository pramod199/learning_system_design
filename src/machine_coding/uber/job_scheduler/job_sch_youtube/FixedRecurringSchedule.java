package machine_coding.uber.job_scheduler.job_sch_youtube;

public class FixedRecurringSchedule implements ISchedulePolicy {
    long initialDelay;
    long interval;

    boolean first;

    public FixedRecurringSchedule(long initialDelay, long interval) {
        this.initialDelay = initialDelay;
        this.interval = interval;
        this.first = true;
    }

    @Override
    public long getNextExecutionTime() {
        if (first) {
            first = false;
            return initialDelay + interval;
        }

        return System.currentTimeMillis() + interval;
    }


    @Override
    public boolean isRecurring() {
        return true;
    }
}
