package lld_algomaster.design_task_management_system.strategy;


import lld_algomaster.design_task_management_system.models.Task;

import java.util.List;

public interface TaskSortStrategy {
    void sort(List<Task> tasks);
}
