package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;
import com.example.demo.entities.Restaurant;

public interface IRestaurantRepository {

    Restaurant save(Restaurant restaurant);
    Optional<Restaurant> findById(Long id);
    List<Restaurant> findAll();
    Restaurant update(Restaurant restaurant);
    void deleteById(Long id);
    boolean existsById(Long id);
    Long count();
    
}
