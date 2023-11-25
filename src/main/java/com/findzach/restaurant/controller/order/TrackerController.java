package com.findzach.restaurant.controller.order;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TrackerController {


    @GetMapping("/order/tracker")
    public String loadPizzaTracker() {
        return "common/content/pizza/tracker";
    }

}
