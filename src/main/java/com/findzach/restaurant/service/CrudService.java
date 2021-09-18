package com.findzach.restaurant.service;

import java.util.Set;

/**
 * @author Zach <zach@findzach.com>
 * @since 9/17/2021
 */
public interface CrudService<T, ID> {

    Set<T> findAll();

    T findById(ID id);

    T create(T object);

    boolean delete(T object);

    /**
     * Deletes Object , finds with ID
     * @param id - The ID of the object
     * @return - True if deleted, false if no record exists
     */
    boolean deleteById(ID id);
}
