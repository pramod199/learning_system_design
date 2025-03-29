package lld.command_design_pattern.undo_redo_function;

public interface ICommand {
    void execute();

    void undo(); // added method for undo.
}
