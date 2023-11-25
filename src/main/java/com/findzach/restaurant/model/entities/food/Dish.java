package com.findzach.restaurant.model.entities.food;

import com.findzach.restaurant.model.entities.Item;
import com.findzach.restaurant.model.entities.food.topping.Topping;

import javax.persistence.Entity;
import java.util.Set;

/**
 * @author: Zach Smith
 * @date: 11/24/2023
 * @time: 7:34 PM
 */
@Entity
public class Dish extends Item {

    Set<FoodItem> foodItems;
    Set<Topping> toppingList;

    public Set<FoodItem> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(Set<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }

    public Set<Topping> getToppingList() {
        return toppingList;
    }

    public void setToppingList(Set<Topping> toppingList) {
        this.toppingList = toppingList;
    }
}
