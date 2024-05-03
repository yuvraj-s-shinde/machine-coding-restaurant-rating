package com.example.demo.services;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.example.demo.entities.Restaurant;
import com.example.demo.repositories.IRestaurantRepository;
import com.example.demo.repositories.RestaurantRepository;

public class RestaurantService {
    private final IRestaurantRepository restaurantRepository;

    public RestaurantService(IRestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }


    public Restaurant createRestaurant(String name) {
        Restaurant r = new Restaurant(name);
        Restaurant restaurant = restaurantRepository.save(r);
        return restaurant;
    }

    public Restaurant describeRestaurant(Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();
        return restaurant;
    }

    public List<Restaurant> listRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        Collections.sort(restaurants, new Comparator<Restaurant>() {

            @Override
            public int compare(Restaurant arg0, Restaurant arg1) {
                // TODO Auto-generated method stub
                return (int) ((double)(arg1.getTotalRating())/arg1.getReviews().size() - (double)(arg1.getTotalRating())/arg1.getReviews().size());
            }
            
        });
        return restaurants;
    }
}
