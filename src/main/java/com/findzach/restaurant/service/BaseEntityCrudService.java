package com.findzach.restaurant.service;

import com.findzach.restaurant.model.BaseEntity;

import java.util.List;

/**
 * @author: Zach Smith
 * @date: 12/3/2023
 * @time: 9:37 AM
 */
public interface BaseEntityCrudService<T extends BaseEntity, ID> extends CrudService<T, ID> {
    //List<T> findByUsername(String username);
}
