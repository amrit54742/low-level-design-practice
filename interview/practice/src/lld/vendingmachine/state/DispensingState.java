package lld.vendingmachine.state;

import lld.vendingmachine.model.VendingMachine;

public class DispensingState implements VendingState {

    public VendingState insertCoin(VendingMachine machine, int coin) {
        System.out.println("Wait. Dispensing.");
        return this;
    }

    public VendingState selectItem(VendingMachine machine) {
        return this;
    }

    public VendingState dispense(VendingMachine machine) {

        System.out.println("Item dispensed.");
        machine.decrementItemCount();

        if (machine.getItemCount() > 0) {
            return machine.getNoCoinState();
        }

        return machine.getSoldOutState();
    }

    public VendingState returnCoin(VendingMachine machine) {
        return this;
    }

    public VendingState refill(VendingMachine machine, int quantity) {
        return this;
    }

    public String getStateName() {
        return "DISPENSING";
    }
}