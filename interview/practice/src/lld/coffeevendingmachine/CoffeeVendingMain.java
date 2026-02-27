package lld.coffeevendingmachine;

import lld.coffeevendingmachine.model.Cappacinno;
import lld.coffeevendingmachine.state.Dispense;
import lld.coffeevendingmachine.state.HasCoinState;
import lld.coffeevendingmachine.state.SelectCoffee;

public class CoffeeVendingMain {
    public static void main(String[] args) {

        CoffeeMachine machine = new CoffeeMachine();

        machine.setInsertedAmount(100);

        machine.setCoffee(new Cappacinno());
        machine.idleState();
        machine.hasACoin();
        machine.dispense();
        machine.printStatus();
    }
}
