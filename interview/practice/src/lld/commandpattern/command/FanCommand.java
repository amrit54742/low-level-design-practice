package lld.commandpattern.command;

import lld.commandpattern.receiver.Fan;

public class FanCommand implements Command {

    private Fan fan;

    public FanCommand(Fan f) {
        this.fan = f;
    }

    public void execute() {
        fan.on();
    }

    public void undo() {
        fan.off();
    }
}
