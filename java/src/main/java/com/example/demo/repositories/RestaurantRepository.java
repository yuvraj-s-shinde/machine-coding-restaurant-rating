package com.example.demo.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.demo.entities.Restaurant;

public class RestaurantRepository implements IRestaurantRepository {

    private final Map<Long, Restaurant> restaurantMap;
    private Long autoIncrement=1L;
    
    public RestaurantRepository() {
        this.restaurantMap = new HashMap<Long, Restaurant>();
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        // TODO Auto-generated method stub
        Restaurant r = new Restaurant(restaurant.getName(), autoIncrement);
        restaurantMap.put(autoIncrement, r);
        ++autoIncrement;
        return r;
    }

    @Override
    public Optional<Restaurant> findById(Long id) {
        // TODO Auto-generated method stub
        return Optional.ofNullable(restaurantMap.get(id));
    }

    @Override
    public List<Restaurant> findAll() {
        // TODO Auto-generated method stub
        return restaurantMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public Restaurant update(Restaurant restaurant) {
        // TODO Auto-generated method stub
        restaurantMap.put(restaurant.getId(), restaurant);
        return restaurant;
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        restaurantMap.remove(id);
    }

    @Override
    public boolean existsById(Long id) {
        // TODO Auto-generated method stub
        return restaurantMap.containsKey(id);
    }

    @Override
    public Long count() {
        // TODO Auto-generated method stub
        return (long) restaurantMap.values().size();
    }



    
}
