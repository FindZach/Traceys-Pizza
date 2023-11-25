package com.findzach.restaurant.model.entities.order;

/**
 * @author: Zach Smith
 * @date: 11/24/2023
 * @time: 7:20 PM
 */
public enum OrderStatus {

    STARTED(),
    PLACED(),
    ACCEPTED(),
    WORKING(),
    READY(),
    DELIVERY(),
    COMPLETED
}
