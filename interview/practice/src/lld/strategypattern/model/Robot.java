package lld.strategypattern.model;

import lld.strategypattern.fly.FlyableRobot;
import lld.strategypattern.talk.TalkableRobot;
import lld.strategypattern.walk.WalkableRobot;

public abstract class Robot {

    protected WalkableRobot walkBehavior;
    protected TalkableRobot talkBehavior;
    protected FlyableRobot flyBehavior;

    public Robot(WalkableRobot w, TalkableRobot t, FlyableRobot f) {
        this.walkBehavior = w;
        this.talkBehavior = t;
        this.flyBehavior = f;
    }

    public void walk() {
        walkBehavior.walk();
    }

    public void talk() {
        talkBehavior.talk();
    }

    public void fly() {
        flyBehavior.fly();
    }

    public abstract void projection();
}