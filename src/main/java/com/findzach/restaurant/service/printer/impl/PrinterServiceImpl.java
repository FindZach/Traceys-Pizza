package com.findzach.restaurant.service.printer.impl;

import com.findzach.restaurant.model.menu.Order;
import com.findzach.restaurant.service.printer.PrinterOptions;
import com.findzach.restaurant.service.printer.PrinterService;
import org.springframework.stereotype.Service;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/17/2021
 */
@Service
public class PrinterServiceImpl implements PrinterService {

    @Override
    public void printReceipt(Order order) {
        PrinterOptions p=new PrinterOptions();

        p.resetAll();
        p.initialize();
        p.feedBack((byte)2);
        p.alignCenter();
        p.setText("Tracey's Pizza");
        p.newLine();
        p.setText("Rochesters Favorite Pizza");
        p.newLine();
        p.addLineSeperator();
        p.setText("go fuck urself bing bong");
        p.newLine();
        p.addLineSeperator();

        p.feed((byte)2);
        p.finit();

        PrinterOptions.feedPrinter(p.finalCommandSet().getBytes());
    }
}
