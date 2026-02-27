package lld.coffeevendingmachine.state;

import lld.coffeevendingmachine.CoffeeMachine;
import lld.coffeevendingmachine.model.Coffee;

public interface CoffeeVendingState {

     CoffeeVendingState insertCoin(CoffeeMachine coffeeMachine, Integer amount);
     CoffeeVendingState hasACoin(CoffeeMachine coffeeMachine, Coffee coffee);
     CoffeeVendingState dispense(CoffeeMachine coffeeMachine);
     String getStateName();


}
