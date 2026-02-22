package lld.strategypattern.model;

import lld.strategypattern.fly.FlyableRobot;
import lld.strategypattern.talk.TalkableRobot;
import lld.strategypattern.walk.WalkableRobot;

public class WorkerRobot extends Robot {

    public WorkerRobot(WalkableRobot w, TalkableRobot t, FlyableRobot f) {
        super(w, t, f);
    }

    public void projection() {
        System.out.println("Displaying worker efficiency stats...");
    }
}