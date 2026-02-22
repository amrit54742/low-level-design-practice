package lld.strategypattern.fly;

public class NoFly implements FlyableRobot {

    public void fly() {
        System.out.println("Cannot fly.");
    }
}