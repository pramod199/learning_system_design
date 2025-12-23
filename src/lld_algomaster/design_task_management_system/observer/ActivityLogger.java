package lld_algomaster.design_task_management_system.observer;

import lld_algomaster.design_task_management_system.models.Task;

public class ActivityLogger implements TaskObserver{
    @Override
    public void update(Task task, String changeType) {
        System.out.println("LOGGER: Task '" + task.getTitle() + "' was updated. Change: " + changeType);
    }
}
