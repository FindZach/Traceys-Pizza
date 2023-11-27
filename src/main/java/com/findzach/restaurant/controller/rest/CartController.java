package com.findzach.restaurant.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: Zach Smith
 * @date: 11/26/2023
 * @time: 6:01 PM
 */
@RestController
public class CartController {

    @GetMapping("/cart/add")
    public boolean addToCart(@RequestParam long itemId, HttpServletRequest request) {
        return false;
    }
}
