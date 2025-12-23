package lld_algomaster.design_task_management_system.observer;

import lld_algomaster.design_task_management_system.models.Task;

public interface TaskObserver {
    void update(Task task, String changeType);
}
