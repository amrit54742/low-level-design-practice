package lld.coffeevendingmachine.machine;

import lld.coffeevendingmachine.coffee.Items;
import lld.coffeevendingmachine.model.Recipe;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<Items, Integer> stock = new HashMap<>();


    public Inventory() {
        for(Items items : Items.values()){
            stock.put(items, 100);
        }
    }

    public boolean hasIngredients(Recipe recipe) {
        for (Map.Entry<Items, Integer> entry : recipe.getComponentsWithAmount().entrySet()) {
            if (stock.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public void deductIngredients(Recipe recipe) {
        for (Map.Entry<Items, Integer> entry : recipe.getComponentsWithAmount().entrySet()) {
            stock.put(entry.getKey(),
                    stock.get(entry.getKey()) - entry.getValue());
        }
    }
    public void displayStock() {
        System.out.println("Current Stock: " + stock);
    }



}
