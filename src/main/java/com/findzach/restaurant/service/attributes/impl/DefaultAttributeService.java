package com.findzach.restaurant.service.attributes.impl;

import com.findzach.restaurant.service.CrudService;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author: Zach Smith
 * @date: 12/2/2023
 * @time: 2:21 PM
 */
@Service
public class DefaultAttributeService implements CrudService<Object, String> {
    private final Map<String, Object> defaultAttributes = new HashMap<>();

    public DefaultAttributeService() {
        defaultAttributes.put("location", "Buffalo, New York");
        defaultAttributes.put("currentYear", Calendar.getInstance().get(Calendar.YEAR));
    }
    /**
     * @return Finds all Default Attributes
     */
    @Override
    public Set<Object> findAll() {
        return (Set<Object>) defaultAttributes.values();
    }

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

}
