package lld.vendingmachine.state;

import lld.vendingmachine.model.VendingMachine;

public class SoldOutState implements VendingState {

    public VendingState insertCoin(VendingMachine machine, int coin) {
        System.out.println("Machine sold out. Coin returned.");
        return this;
    }

    public VendingState selectItem(VendingMachine machine) {
        return this;
    }

    public VendingState dispense(VendingMachine machine) {
        return this;
    }

    public VendingState returnCoin(VendingMachine machine) {
        return this;
    }

    public VendingState refill(VendingMachine machine, int quantity) {
        machine.incrementItemCount(quantity);
        return machine.getNoCoinState();
    }

    public String getStateName() {
        return "SOLD_OUT";
    }
}