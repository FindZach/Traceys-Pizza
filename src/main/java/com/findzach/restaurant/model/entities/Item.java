package com.findzach.restaurant.model.entities;

import com.findzach.restaurant.model.BaseEntity;
import com.findzach.restaurant.model.entities.menu.Category;
import com.findzach.restaurant.model.entities.menu.MenuType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/17/2021
 *
 * @description Represents an item of sale
 */
@MappedSuperclass
public abstract class Item extends BaseEntity {
    protected String itemName;
    protected String description;

    @Enumerated(EnumType.STRING)
    private MenuType menuType;

    @Enumerated(EnumType.STRING)
    private Category category;

    private double price;
    private int amount;

    @Lob
    private String base64Image;

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


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getImage() {
        return base64Image;
    }

    public void setImage(String base64Image) {
        this.base64Image = base64Image;
    }
}
