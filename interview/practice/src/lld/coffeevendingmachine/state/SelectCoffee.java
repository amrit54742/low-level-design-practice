package lld.coffeevendingmachine.state;

import lld.coffeevendingmachine.CoffeeMachine;
import lld.coffeevendingmachine.model.Coffee;

public class SelectCoffee implements CoffeeVendingState{
    @Override
    public CoffeeVendingState insertCoin(CoffeeMachine coffeeMachine, Integer amount) {
        System.out.println("(inside insert coin)Coin inserted and amount is " + amount );
        coffeeMachine.setInsertedAmount(amount);
        return coffeeMachine.getHasACoinState();
//        return this;
    }

    @Override
    public CoffeeVendingState hasACoin(CoffeeMachine coffeeMachine, Coffee coffee) {
        System.out.println("(inside insert coin()has a coin) first insert a coin" );
        return coffeeMachine.getSelectCoffee();
    }

    @Override
    public CoffeeVendingState dispense(CoffeeMachine coffeeMachine) {
        System.out.println("(inside insert coin(dispense)) first insert a coin" );
        return coffeeMachine.getSelectCoffee();
    }

    @Override
    public String getStateName() {
        return "select or idle state";
    }
}
