package com.findzach.restaurant.service.food.impl;

import com.findzach.restaurant.model.entities.food.topping.Topping;
import com.findzach.restaurant.repository.food.ToppingRepository;
import com.findzach.restaurant.service.food.ToppingService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Zach Smith
 * @date: 12/3/2023
 * @time: 6:12 PM
 */
@Service
public class ToppingServiceImpl implements ToppingService {

    private final ToppingRepository toppingRepository;

    public ToppingServiceImpl(ToppingRepository toppingRepository) {
        this.toppingRepository = toppingRepository;
    }

    /**
     * @return
     */
    @Override
    public List<Topping> findAll() {
        return toppingRepository.findAll();
    }

    /**
     * @param aLong
     * @return
     */
    @Override
    public Topping findById(Long aLong) {
        return toppingRepository.findById(aLong).orElse(null);
    }

    /**
     * @param object
     * @return
     */
    @Override
    public Topping create(Topping object) {
        return toppingRepository.save(object);
    }

    /**
     * @param object
     * @return
     */
    @Override
    public boolean delete(Topping object) {
        toppingRepository.delete(object);
        return true;
    }

    /**
     * @param aLong - The ID of the object
     * @return
     */
    @Override
    public boolean deleteById(Long aLong) {
        toppingRepository.deleteById(aLong);
        return true;
    }

    /**
     * @param object
     * @return
     */
    @Override
    public Topping save(Topping object) {
        return toppingRepository.save(object);
    }
}
