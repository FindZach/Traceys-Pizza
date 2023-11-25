package com.findzach.restaurant.model.entities.food.topping;

import com.findzach.restaurant.model.entities.Item;

/**
 * @author: Zach Smith
 * @date: 11/24/2023
 * @time: 7:30 PM
 */
public class Topping extends Item {

    //Default to normal amount
    private ToppingQuantity quantity = ToppingQuantity.NORMAL;
}
