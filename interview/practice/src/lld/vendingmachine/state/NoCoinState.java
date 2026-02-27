package lld.vendingmachine.state;

import lld.vendingmachine.model.VendingMachine;

public class NoCoinState implements VendingState {

    public VendingState insertCoin(VendingMachine machine, int coin) {
        machine.addAmount(coin);
        System.out.println("Coin inserted and amount is " + coin );
        return machine.getHasCoinState();
    }

    public VendingState selectItem(VendingMachine machine) {
        System.out.println("Insert coin first.");
        return this;
    }

    public VendingState dispense(VendingMachine machine) {
        System.out.println("No item selected.");
        return this;
    }

    public VendingState returnCoin(VendingMachine machine) {
        System.out.println("No coin to return.");
        return this;
    }

    public VendingState refill(VendingMachine machine, int quantity) {
        machine.incrementItemCount(quantity);
        return this;
    }

    public String getStateName() {
        return "NO_COIN";
    }
}