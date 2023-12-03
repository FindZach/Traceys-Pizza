package com.findzach.restaurant.service.attributes;

import com.findzach.restaurant.service.CrudService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Zach Smith
 * @date: 12/2/2023
 * @time: 2:20 PM
 *
 * Interface to populate our Attributes in Model object
 */
public interface AttributeService<T, Id> extends CrudService<T, Id> {
    Map<String, Object> defaultAttributes = new HashMap<>();

}
