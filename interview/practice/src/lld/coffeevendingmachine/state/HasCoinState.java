package lld.coffeevendingmachine.state;

import lld.coffeevendingmachine.CoffeeMachine;
import lld.coffeevendingmachine.model.Coffee;

public class HasCoinState implements CoffeeVendingState {
    @Override
    public CoffeeVendingState insertCoin(CoffeeMachine coffeeMachine, Integer amount) {
        System.out.println("(inside hasACoin) inserting more coins" + amount );
        coffeeMachine.addAmount(amount, coffeeMachine);
        return coffeeMachine.getHasACoinState();
    }

    @Override
    public CoffeeVendingState hasACoin(CoffeeMachine coffeeMachine, Coffee coffee) {
        System.out.println("(inside hasACoin) setting the coffee " );
        coffeeMachine.setCoffee(coffee);
        return coffeeMachine.getDispenseState();

    }

    @Override
    public CoffeeVendingState dispense(CoffeeMachine coffeeMachine) {
        System.out.println("(inside hasACoin) first select the item" );

        return coffeeMachine.getHasACoinState();
    }

    @Override
    public String getStateName() {
        return "has a coin";
    }
}
