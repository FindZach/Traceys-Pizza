package com.findzach.restaurant.model.entities.food.topping;

import com.findzach.restaurant.model.entities.Item;
import com.findzach.restaurant.model.entities.menu.MenuType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * @author: Zach Smith
 * @date: 11/24/2023
 * @time: 7:30 PM
 */
@Entity
public class Topping extends Item {

    //Default to normal amount
    @Enumerated(EnumType.STRING)
    private ToppingQuantity quantity = ToppingQuantity.NORMAL;

    public Topping() {
        super();
        setMenuType(MenuType.TOPPING);
    }

    public ToppingQuantity getQuantity() {
        return quantity;
    }

    public void setQuantity(ToppingQuantity quantity) {
        this.quantity = quantity;
    }
}
