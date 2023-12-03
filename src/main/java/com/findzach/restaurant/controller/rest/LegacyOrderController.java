package com.findzach.restaurant.controller.rest;

import com.findzach.restaurant.model.entities.order.Order;
import com.findzach.restaurant.service.printer.PrinterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/17/2021
 */
@CrossOrigin(maxAge = 3600)
@Controller
public class LegacyOrderController {

    @Autowired
    private PrinterService printerService;


    @GetMapping("api/v1/order")
    public String getActiveOrders() {
        printerService.printReceipt(new Order());
        return "admin";
    }


}
