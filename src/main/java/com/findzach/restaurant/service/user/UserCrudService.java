package com.findzach.restaurant.service.user;

import com.findzach.restaurant.model.entities.user.User;
import com.findzach.restaurant.service.BaseEntityCrudService;

/**
 * @author: Zach Smith
 * @date: 12/6/2023
 * @time: 9:46 PM
 */
public interface UserCrudService<T extends User, Id> extends BaseEntityCrudService<T, Id> {
    T findByUsername(String username);

}
