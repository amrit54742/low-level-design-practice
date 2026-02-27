package lld.commandpattern.command;

import lld.commandpattern.receiver.Light;

public class LightCommand implements Command {

    private Light light;

    public LightCommand(Light l) {
        this.light = l;
    }

    public void execute() {
        light.on();
    }

    public void undo() {
        light.off();
    }
}