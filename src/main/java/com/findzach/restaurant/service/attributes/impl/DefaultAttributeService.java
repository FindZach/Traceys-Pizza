package com.findzach.restaurant.service.attributes.impl;

import com.findzach.restaurant.model.entities.food.topping.Topping;
import com.findzach.restaurant.model.entities.menu.Category;
import com.findzach.restaurant.model.entities.menu.MenuType;
import com.findzach.restaurant.repository.food.ToppingRepository;
import com.findzach.restaurant.service.attributes.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author: Zach Smith
 * @date: 12/2/2023
 * @time: 2:21 PM
 */
@Service
public class DefaultAttributeService implements AttributeService<Object, String> {
    private final Map<String, Object> defaultAttributes = new HashMap<>();

    enum LoginState {
        LOGGED_OUT,
        LOGGED_IN
    }

    public DefaultAttributeService() {
        defaultAttributes.put("currentYear", Calendar.getInstance().get(Calendar.YEAR));
        defaultAttributes.put("loginState", "LOGIN / JOIN");

        defaultAttributes.put("categoriesList", Category.values());
        defaultAttributes.put("menuTypes", MenuType.values());
    }

    private List<Topping> formToppingsList() {
        List<Topping> toppings = new ArrayList<>();

        Topping cheese = new Topping();
        Topping tomato = new Topping();
        Topping relish = new Topping();
        Topping mayo = new Topping();
        Topping mustard = new Topping();
        toppings.add(cheese);
        toppings.add(tomato);
        toppings.add(relish);
        toppings.add(mayo);
        toppings.add(mustard);
        cheese.setItemName("Cheese");
        cheese.setPrice(.75);
        tomato.setItemName("Tomato");
        tomato.setPrice(.75);
        relish.setItemName("Relish");
        relish.setPrice(.75);
        mayo.setItemName("Mayo");
        mayo.setPrice(.75);
        mustard.setItemName("Mustard");
        mustard.setPrice(.75);

        return toppings;
    }

    /**
     * @return Finds all Default Attributes
     */
    @Override
    public List<Object> findAll() {
        return (List<Object>) defaultAttributes.values();
    }

    @Cacheable("defaultAttributeMap")
    public Map<String, Object> getAll() {
        return defaultAttributes;
    }

    /**
     * @param key Finds object by String key
     * @return Object associated with key
     */
    @Override
    public Object findById(String key) {
        return defaultAttributes.get(key);
    }

    public Object create(String key, Object object) {
        if (defaultAttributes.containsKey(key)) return defaultAttributes.get(key);
        //Only create if not yet registered
       return defaultAttributes.put(key, object);
    }

    public Object update(String key, Object object) {
        //Allow Override
        return defaultAttributes.put(key, object);
    }
    /**
     * @param object
     * @return
     */
    @Override
    public Object create(Object object) {
        return null;
    }

    /**
     * @param object
     * @return
     */
    @Override
    public boolean delete(Object object) {
        return false;
    }

    /**
     * @param selectedKey - The key of the object
     * @return
     */
    @Override
    public boolean deleteById(String selectedKey) {
        return defaultAttributes.keySet().removeIf(key -> selectedKey.equalsIgnoreCase(key));
    }

    /**
     * @param object
     * @return
     */
    @Override
    public Object save(Object object) {
        return null;
    }

}
