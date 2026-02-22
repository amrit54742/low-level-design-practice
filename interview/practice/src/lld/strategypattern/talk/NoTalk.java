package lld.strategypattern.talk;

public class NoTalk implements TalkableRobot {

    public void talk() {
        System.out.println("Cannot talk.");
    }
}