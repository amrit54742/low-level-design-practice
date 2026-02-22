package lld.strategypattern.model;

import lld.strategypattern.fly.FlyableRobot;
import lld.strategypattern.talk.TalkableRobot;
import lld.strategypattern.walk.WalkableRobot;

public class CompanionRobot extends Robot {

    public CompanionRobot(WalkableRobot w, TalkableRobot t, FlyableRobot f) {
        super(w, t, f);
    }

    public void projection() {
        System.out.println("Displaying friendly companion features...");
    }
}