package com.findzach.restaurant.model;

/**
 * @author Zach <zach@findzach.com>
 * @since 9/17/2021
 *
 * Will help manage and control Workable 'users'
 */
public interface Workable {

    /**
     * Checks Work Status
     * @return - True if working, false if not working
     */
    boolean isWorking();

    /**
     * Will adjust the Employees' Status and update the proper fields
     * @return True if shift is beginning, false if shift is ending.
     */
    boolean toggleWork();
}
