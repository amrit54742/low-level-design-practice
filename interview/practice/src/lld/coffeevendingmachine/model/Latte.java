package lld.coffeevendingmachine.model;

import lld.coffeevendingmachine.coffee.Items;

import java.util.Map;

public class Latte implements Coffee{


    @Override
    public String getCoffeeName() {
        return "latte";
    }

    @Override
    public Recipe getRecipe() {
        return new Recipe(Map.of(Items.MILK, 20,
        Items.LATTE, 25), 50);
    }
}
