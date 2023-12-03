package com.findzach.restaurant.controller.pages.redirect;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: Zach Smith
 * @date: 12/2/2023
 * @time: 2:52 PM
 */
@Controller
public class FZErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        // Redirect to your custom 404 page
        return "/common/redirects/404"; // Assuming your custom 404 page is named "custom404.html" or "custom404.jsp"
    }

}
