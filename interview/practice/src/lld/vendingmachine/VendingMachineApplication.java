package lld.vendingmachine;

import lld.vendingmachine.model.VendingMachine;

public class VendingMachineApplication {

    public static void main(String[] args) {

        VendingMachine machine = new VendingMachine(2, 20);

        machine.printStatus();

        machine.insertCoin(10);
        machine.insertCoin(10);
        machine.selectItem();
        machine.dispense();

        machine.printStatus();
    }

}
