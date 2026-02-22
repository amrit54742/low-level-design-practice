package lld.vendingmachine.model;

import lld.vendingmachine.state.*;

public class VendingMachine {

    private VendingState currentState;

    private final VendingState noCoinState;
    private final VendingState hasCoinState;
    private final VendingState dispensingState;
    private final VendingState soldOutState;

    private int itemCount;
    private int itemPrice;
    private int insertedAmount;

    public VendingMachine(int itemCount, int itemPrice) {

        this.itemCount = itemCount;
        this.itemPrice = itemPrice;

        this.noCoinState = new NoCoinState();
        this.hasCoinState = new HasCoinState();
        this.dispensingState = new DispensingState();
        this.soldOutState = new SoldOutState();

        this.currentState = itemCount > 0 ? noCoinState : soldOutState;
    }

    public void insertCoin(int coin) {
        currentState = currentState.insertCoin(this, coin);
    }

    public void selectItem() {
        currentState = currentState.selectItem(this);
    }

    public void dispense() {
        currentState = currentState.dispense(this);
    }

    public void returnCoin() {
        currentState = currentState.returnCoin(this);
    }

    public void refill(int quantity) {
        currentState = currentState.refill(this, quantity);
    }

    // Getters & Setters

    public int getItemCount() { return itemCount; }

    public void decrementItemCount() { itemCount--; }

    public void incrementItemCount(int quantity) { itemCount += quantity; }

    public int getInsertedAmount() { return insertedAmount; }

    public void addAmount(int amount) { insertedAmount += amount; }

    public void resetAmount() { insertedAmount = 0; }

    public int getItemPrice() { return itemPrice; }

    public VendingState getNoCoinState() { return noCoinState; }

    public VendingState getHasCoinState() { return hasCoinState; }

    public VendingState getDispensingState() { return dispensingState; }

    public VendingState getSoldOutState() { return soldOutState; }

    public void printStatus() {
        System.out.println("Items: " + itemCount);
        System.out.println("Balance: Rs " + insertedAmount);
        System.out.println("State: " + currentState.getStateName());
        System.out.println();
    }
}