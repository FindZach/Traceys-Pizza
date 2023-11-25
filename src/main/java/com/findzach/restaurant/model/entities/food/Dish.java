package com.findzach.restaurant.model.entities.food;

import com.findzach.restaurant.model.entities.Item;
import com.findzach.restaurant.model.entities.food.topping.Topping;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Zach Smith
 * @date: 11/24/2023
 * @time: 7:34 PM
 */
@Entity
public class Dish extends Item {
    @ManyToMany
    @JoinTable(
            name = "dish_food_item",
            joinColumns = @JoinColumn(name = "dish_id"),
            inverseJoinColumns = @JoinColumn(name = "food_item_id")
    )
    private List<FoodItem> components = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "dish_topping",
            joinColumns = @JoinColumn(name = "dish_id"),
            inverseJoinColumns = @JoinColumn(name = "topping_id")
    )
    private List<Topping> toppings = new ArrayList<>();

    public List<FoodItem> getComponents() {
        return components;
    }

    public void setComponents(List<FoodItem> components) {
        this.components = components;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }
}
