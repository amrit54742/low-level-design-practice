package lld.strategypattern;

import lld.strategypattern.fly.NoFly;
import lld.strategypattern.fly.NormalFly;
import lld.strategypattern.model.CompanionRobot;
import lld.strategypattern.model.Robot;
import lld.strategypattern.model.WorkerRobot;
import lld.strategypattern.talk.NoTalk;
import lld.strategypattern.talk.NormalTalk;
import lld.strategypattern.walk.NoWalk;
import lld.strategypattern.walk.NormalWalk;

public class StrategyDesignPattern {

    public static void main(String[] args) {

        Robot robot1 = new CompanionRobot(
                new NormalWalk(),
                new NormalTalk(),
                new NoFly()
        );

        robot1.walk();
        robot1.talk();
        robot1.fly();
        robot1.projection();

        System.out.println("--------------------");

        Robot robot2 = new WorkerRobot(
                new NoWalk(),
                new NoTalk(),
                new NormalFly()
        );

        robot2.walk();
        robot2.talk();
        robot2.fly();
        robot2.projection();
    }
}