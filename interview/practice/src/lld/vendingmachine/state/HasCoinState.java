package lld.vendingmachine.state;

import lld.vendingmachine.model.VendingMachine;

public class HasCoinState implements VendingState {

    public VendingState insertCoin(VendingMachine machine, int coin) {
        System.out.println("(inside hascoinstate)Coin inserted and amount is " + coin );
        machine.addAmount(coin);
        System.out.println("(inside hascoinstate)total amount is " + machine.getInsertedAmount() );
        return this;
    }

    public VendingState selectItem(VendingMachine machine) {

        if (machine.getInsertedAmount() >= machine.getItemPrice()) {
            System.out.println("(inside hascoinstate)the total amount before dispensing is " + machine.getInsertedAmount() );

            int change = machine.getInsertedAmount() - machine.getItemPrice();
            System.out.println("(inside hascoinstate) change value is " + change);
            if (change > 0) {
                System.out.println("Change returned: Rs " + change);
            }

            machine.resetAmount();
            return machine.getDispensingState();
        }

        System.out.println("Insufficient balance.");
        return this;
    }

    public VendingState dispense(VendingMachine machine) {
        System.out.println("Select item first.");
        return this;
    }

    public VendingState returnCoin(VendingMachine machine) {
        System.out.println("Returning Rs " + machine.getInsertedAmount());
        machine.resetAmount();
        return machine.getNoCoinState();
    }

    public VendingState refill(VendingMachine machine, int quantity) {
        return this;
    }

    public String getStateName() {
        return "HAS_COIN";
    }
}
