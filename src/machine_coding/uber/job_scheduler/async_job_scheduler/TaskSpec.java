package machine_coding.uber.job_scheduler.async_job_scheduler;

import java.util.ArrayList;
import java.util.List;

class TaskSpec {
    Task task;
    SchedulePolicy policy;
    List<String> dependencies = new ArrayList<>();

    public TaskSpec task(Task t) {
        this.task = t;
        return this;
    }

    public TaskSpec policy(SchedulePolicy p) {
        this.policy = p;
        return this;
    }

    public TaskSpec dependsOn(String parent) {
        this.dependencies.add(parent);
        return this;
    }

}