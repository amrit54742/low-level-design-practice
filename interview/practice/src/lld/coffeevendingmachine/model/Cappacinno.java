package lld.coffeevendingmachine.model;

import lld.coffeevendingmachine.coffee.Items;

import java.util.Map;

public class Cappacinno implements Coffee{
    @Override
    public String getCoffeeName() {
        return "Cappacinno";
    }

    @Override
    public Recipe getRecipe() {
        return new Recipe(Map.of(Items.MILK, 15,
        Items.CAPPACINNO, 20),70);
    }
}
