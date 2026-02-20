package machine_coding.uber.job_scheduler.job_sch_youtube;

public class OneTimeSchedule implements ISchedulePolicy {
    long initialDelay;

    public OneTimeSchedule(long initialDelay) {
        this.initialDelay = initialDelay;
    }


    @Override
    public long getNextExecutionTime() {
        return initialDelay;
    }

    @Override
    public boolean isRecurring() {
        return false;
    }
}
