package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Restaurant;
import com.example.demo.services.RestaurantService;

public class DescribeRestaurantCommand implements ICommand {
    private final RestaurantService restaurantService;

    public DescribeRestaurantCommand(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }
    
    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        Long restaurantId = Long.parseLong(tokens.get(1));
        Restaurant restaurant = restaurantService.describeRestaurant(restaurantId);
        Double averageRating = (double) (restaurant.getTotalRating())/restaurant.getReviews().size();
        averageRating = Math.round(averageRating * Math.pow(10, 1))/ Math.pow(10, 1);
        System.out.println("Restaurant [id=" + restaurant.getId() + ", name=" + restaurant.getName() + ", rating=" + averageRating + "]");
    }

}
