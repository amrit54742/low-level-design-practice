package lld.chainofresponsibility.handler;

public abstract class MoneyHandler {

    protected MoneyHandler nextHandler;

    public MoneyHandler() {
        this.nextHandler = null;
    }

    public void setNextHandler(MoneyHandler next) {
        this.nextHandler = next;
    }

    public abstract void dispense(int amount);
}