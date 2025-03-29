package lld.command_design_pattern.undo_redo_function;

import java.util.Stack;

public class MyRemoteControl {
    Stack<ICommand> undoStack = new Stack<>();
    Stack<ICommand> redoStack = new Stack<>();
    ICommand command;

    public MyRemoteControl() {

    }

    public void setCommand(ICommand command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
        undoStack.push(command);
        redoStack.clear(); // clear redo stack on new action.
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            ICommand command = undoStack.pop();
            command.undo();
            redoStack.push(command);
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            ICommand command = redoStack.pop();
            command.execute();
            undoStack.push(command);
        }
    }

}
