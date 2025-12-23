package lld_algomaster.design_task_management_system.state;


import lld_algomaster.design_task_management_system.enums.TaskStatus;
import lld_algomaster.design_task_management_system.models.Task;

public class TodoState implements TaskState {

    @Override
    public void startProgress(Task task) {
        task.setState(new InProgressState());
    }
    @Override
    public void completeTask(Task task) {
        System.out.println("Cannot complete a task that is not in progress.");
    }
    @Override
    public void reopenTask(Task task) {
        System.out.println("Task is already in TO-DO state.");
    }
    @Override
    public TaskStatus getStatus() { return TaskStatus.TODO; }
}
