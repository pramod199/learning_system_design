package machine_coding.uber.job_scheduler.job_sch_youtube;

import java.util.ArrayList;
import java.util.List;

public class TaskSpec {
    Task task;
    ISchedulePolicy policy;
    List<String> dependencies = new ArrayList<>();

    public TaskSpec(Task task) {
        this.task = task;
    }

    public TaskSpec policy(ISchedulePolicy policy){
        this.policy = policy;
        return this;
    }

    public TaskSpec dependsOn(List<String> depIds){
        this.dependencies = depIds;
        return this;
    }
}
