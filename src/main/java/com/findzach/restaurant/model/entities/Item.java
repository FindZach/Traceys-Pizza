package com.findzach.restaurant.model.entities;

import com.findzach.restaurant.model.BaseEntity;
import com.findzach.restaurant.model.menu.MenuType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/17/2021
 *
 * @description Represents an item of sale
 */
@MappedSuperclass
public abstract class Item extends BaseEntity {

    private String itemName;
    private String description;

    @Enumerated(EnumType.STRING)
    private MenuType menuType;

    private double price;
    //The amount of this item
    private int quantity;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MenuType getMenuType() {
        return menuType;
    }

    public void setMenuType(MenuType menuType) {
        this.menuType = menuType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
