package com.findzach.restaurant.controller.pages;

import com.findzach.restaurant.model.entities.Item;
import com.findzach.restaurant.model.entities.food.topping.Topping;
import com.findzach.restaurant.repository.food.ToppingRepository;
import com.findzach.restaurant.service.food.ToppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Base64;

/**
 * @author: Zach Smith
 * @date: 12/3/2023
 * @time: 5:59 PM
 */
@Controller
@RequestMapping("/addItem")
public class ItemController {

    @Autowired
    private final ToppingService toppingService;

    public ItemController(ToppingService toppingService) {
        this.toppingService = toppingService;
    }

    @PostMapping
    public ModelAndView addItem(@RequestParam("itemName") String itemName,
                                @RequestParam("itemPrice") double itemPrice,
                                @RequestParam("itemDescription") String itemDescription,
                                @RequestParam("itemType") String itemType,
                                @RequestParam("itemImage") MultipartFile itemImage) {
        System.out.println("itemName: " + itemName);
        System.out.println("itemName: " + itemPrice);
        System.out.println("itemName: " + itemDescription);
        System.out.println("itemName: " + itemType);
        System.out.println("itemName: " + itemImage);
        // Process the form data here
        // Save the item details and image
        Topping newTopping = new Topping();

        newTopping.setItemName(itemName);
        newTopping.setPrice(itemPrice);
        newTopping.setDescription(itemDescription);


        try {
            byte[] imageBytes = itemImage.getBytes();
            String base64Image = Base64.getEncoder().encodeToString(imageBytes);
            newTopping.setImage(base64Image); // Assuming setImage() accepts a String
            // Save newTopping to the database
        } catch (IOException e) {
            // Handle the exception
            System.out.println("Failed to save IMAGE!");
        }

        toppingService.create(newTopping);

        // Redirect to a success page or display a success message
        return new ModelAndView("redirect:/success");
    }
}
