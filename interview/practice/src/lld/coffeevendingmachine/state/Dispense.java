package lld.coffeevendingmachine.state;

import lld.coffeevendingmachine.CoffeeMachine;
import lld.coffeevendingmachine.model.Coffee;

public class Dispense implements CoffeeVendingState{
    @Override
    public CoffeeVendingState insertCoin(CoffeeMachine coffeeMachine, Integer amount) {
        System.out.println("(inside dispense(insert coin)) wait .. currently dispensing the coffee " );
        return coffeeMachine.getDispenseState();
    }

    @Override
    public CoffeeVendingState hasACoin(CoffeeMachine coffeeMachine, Coffee coffee) {
        System.out.println("(inside dispense(hasacoin)) wait .. currently dispensing the coffee " );
        coffeeMachine.setCoffee(coffee);
        return coffeeMachine.getDispenseState();
    }

    @Override
    public CoffeeVendingState dispense(CoffeeMachine coffeeMachine) {
        Coffee coffee= coffeeMachine.getCoffee();
        if (!coffeeMachine.getInventory().hasIngredients(coffee.getRecipe())){
            System.out.println("Not enough ingredients! so returning the money");
            coffeeMachine.setInsertedAmount(0);
            coffeeMachine.setCurrentCoffeeVendingState(coffeeMachine.getSelectCoffee());
            return coffeeMachine.getSelectCoffee();
        }
        if (coffeeMachine.getInsertedAmount() < coffee.getRecipe().getPrice()) {
            System.out.println("Not enough money!");
            coffeeMachine.setInsertedAmount(0);
            coffeeMachine.setCurrentCoffeeVendingState(coffeeMachine.getSelectCoffee());
            return coffeeMachine.getSelectCoffee();
        }
        coffeeMachine.getInventory().deductIngredients(coffee.getRecipe());
        Integer refund= coffeeMachine.getInsertedAmount() - coffeeMachine.getCoffee().getRecipe().getPrice();
        System.out.println("updating the refund amount->  " + refund);
        coffeeMachine.setInsertedAmount(coffeeMachine.getInsertedAmount() - coffeeMachine.getCoffee().getRecipe().getPrice());

        System.out.println("Dispensing " + coffee.getCoffeeName());

        coffeeMachine.setCurrentCoffeeVendingState(coffeeMachine.getSelectCoffee());
        return coffeeMachine.getSelectCoffee();
    }

    @Override
    public String getStateName() {
        return "dispense";
    }
}
