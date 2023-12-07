package com.findzach.restaurant.service.user;

import com.findzach.restaurant.model.entities.user.User;

/**
 * @author: Zach Smith
 * @date: 12/6/2023
 * @time: 9:29 PM
 */
public interface UserService extends UserCrudService<User, Long> {
    UserCrudService getUserService(User object);

}
