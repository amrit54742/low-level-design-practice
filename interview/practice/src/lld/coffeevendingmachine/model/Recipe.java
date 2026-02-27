package lld.coffeevendingmachine.model;

import lld.coffeevendingmachine.coffee.Items;


import java.util.Map;


public class Recipe {
    private Map<Items, Integer> componentsWithAmount;
    private Integer price;

    public Recipe() {
    }

    public Recipe(Map<Items, Integer> componentsWithAmount, Integer price) {
        this.componentsWithAmount = componentsWithAmount;
        this.price = price;
    }

    public Map<Items, Integer> getComponentsWithAmount() {
        return componentsWithAmount;
    }

    public void setComponentsWithAmount(Map<Items, Integer> componentsWithAmount) {
        this.componentsWithAmount = componentsWithAmount;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


}






