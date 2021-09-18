package com.findzach.restaurant.service.printer;

import com.findzach.restaurant.model.menu.Order;

/**
 * @author Zach <zach@findzach.com>
 * @since 9/17/2021
 */
public interface PrinterService {

    void printReceipt(Order order);
}
