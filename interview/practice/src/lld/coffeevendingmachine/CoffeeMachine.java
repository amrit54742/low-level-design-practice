package lld.coffeevendingmachine;

import lld.coffeevendingmachine.machine.Inventory;
import lld.coffeevendingmachine.model.Coffee;
import lld.coffeevendingmachine.state.CoffeeVendingState;
import lld.coffeevendingmachine.state.Dispense;
import lld.coffeevendingmachine.state.HasCoinState;
import lld.coffeevendingmachine.state.SelectCoffee;


public class CoffeeMachine {
    private Integer insertedAmount;
    private Coffee coffee;
    private CoffeeVendingState currentCoffeeVendingState;

    private Inventory inventory;

    private CoffeeVendingState selectCoffee;
    private CoffeeVendingState hasACoinState;
    private CoffeeVendingState dispenseState;

    public CoffeeMachine() {
        this.insertedAmount=0;
        this.selectCoffee = new SelectCoffee();
        this.hasACoinState = new HasCoinState();
        this.dispenseState = new Dispense();
        this.currentCoffeeVendingState = new SelectCoffee();
        this.inventory= new Inventory();

    }

    public void dispense(){
        currentCoffeeVendingState= currentCoffeeVendingState.dispense(this);
    }
    public void hasACoin(){
        currentCoffeeVendingState= currentCoffeeVendingState.hasACoin(this, this.getCoffee());
    }
    public void idleState(){
        currentCoffeeVendingState= currentCoffeeVendingState.insertCoin(this, insertedAmount);
    }

    public void addAmount(Integer amount, CoffeeMachine coffeeMachine){
        insertedAmount= insertedAmount+  amount;
    }

    public Integer getInsertedAmount() {
        return insertedAmount;
    }

    public void setInsertedAmount(Integer insertedAmount) {
        this.insertedAmount = insertedAmount;
    }

    // ===== coffee =====
    public Coffee getCoffee() {
        return coffee;
    }

    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    // ===== currentCoffeeVendingState =====
    public CoffeeVendingState getCurrentCoffeeVendingState() {
        return currentCoffeeVendingState;
    }

    public void setCurrentCoffeeVendingState(CoffeeVendingState currentCoffeeVendingState) {
        this.currentCoffeeVendingState = currentCoffeeVendingState;
    }

    // ===== inventory =====
    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    // ===== selectCoffee =====
    public CoffeeVendingState getSelectCoffee() {
        return selectCoffee;
    }

    public void setSelectCoffee(CoffeeVendingState selectCoffee) {
        this.selectCoffee = selectCoffee;
    }

    // ===== hasACoinState =====
    public CoffeeVendingState getHasACoinState() {
        return hasACoinState;
    }

    public void setHasACoinState(CoffeeVendingState hasACoinState) {
        this.hasACoinState = hasACoinState;
    }

    // ===== dispenseState =====
    public CoffeeVendingState getDispenseState() {
        return dispenseState;
    }

    public void setDispenseState(CoffeeVendingState dispenseState) {
        this.dispenseState = dispenseState;
    }
    public void printStatus() {
        System.out.println("coffee: " + coffee);
        System.out.println("Balance: Rs " + insertedAmount);
        System.out.println("State: " + currentCoffeeVendingState.getStateName());
        System.out.println();
    }

}
