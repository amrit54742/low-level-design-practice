package lld.strategypattern.walk;

public class NoWalk implements WalkableRobot {

    public void walk() {
        System.out.println("Cannot walk.");
    }
}