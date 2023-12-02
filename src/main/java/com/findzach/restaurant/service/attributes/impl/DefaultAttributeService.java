package com.findzach.restaurant.service.attributes.impl;

import com.findzach.restaurant.service.CrudService;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author: Zach Smith
 * @date: 12/2/2023
 * @time: 2:21 PM
 */
public class DefaultAttributeService implements CrudService<Object, String> {
    private final Map<String, Object> defaultAttributes = new HashMap<>();
    /**
     * @return Finds all Default Attributes
     */
    @Override
    public Set<Object> findAll() {
        return (Set<Object>) defaultAttributes.values();
    }

    /**
     * @param Finds object by String key
     * @return Object associated with key
     */
    @Override
    public Object findById(String s) {
        return defaultAttributes.get(s);
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
        return defaultAttributes.remove(object) != null;
    }

    /**
     * @param s - The ID of the object
     * @return
     */
    @Override
    public boolean deleteById(String s) {
        return defaultAttributes.keySet().stream().anyMatch(s1 -> s.equalsIgnoreCase(s1));
    }
}
