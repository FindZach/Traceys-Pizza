package com.findzach.restaurant.model.entities;

import com.findzach.restaurant.model.BaseEntity;
import com.findzach.restaurant.model.menu.MenuType;

import javax.persistence.MappedSuperclass;
import java.awt.*;
import java.util.List;
import java.util.Set;

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

    private Set<MenuType> menuTypes;

    private double price;
    //The amount of this item
    private int quantity;
}
