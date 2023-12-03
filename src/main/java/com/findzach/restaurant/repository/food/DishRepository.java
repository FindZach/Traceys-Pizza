package com.findzach.restaurant.repository.food;

import com.findzach.restaurant.model.entities.food.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: Zach Smith
 * @date: 11/24/2023
 * @time: 8:25 PM
 */
@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {

}
