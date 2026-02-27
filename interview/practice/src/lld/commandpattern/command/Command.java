package lld.commandpattern.command;

public interface Command {
    void execute();
    void undo();
}