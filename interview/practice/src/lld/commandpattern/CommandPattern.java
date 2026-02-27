package lld.commandpattern;

import lld.commandpattern.command.FanCommand;
import lld.commandpattern.command.LightCommand;
import lld.commandpattern.invoker.RemoteController;
import lld.commandpattern.receiver.Fan;
import lld.commandpattern.receiver.Light;

public class CommandPattern {

    public static void main(String[] args) {

        Light livingRoomLight = new Light();
        Fan ceilingFan = new Fan();

        RemoteController remote = new RemoteController();

        remote.setCommand(0, new LightCommand(livingRoomLight));
        remote.setCommand(1, new FanCommand(ceilingFan));

        System.out.println("--- Toggling Light Button 0 ---");
        remote.pressButton(0);
        remote.pressButton(0);

        System.out.println("--- Toggling Fan Button 1 ---");
        remote.pressButton(1);
        remote.pressButton(1);

        System.out.println("--- Pressing Unassigned Button 2 ---");
        remote.pressButton(2);
    }
}