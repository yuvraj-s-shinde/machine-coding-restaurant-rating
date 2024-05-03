package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Review;
import com.example.demo.services.ReviewService;

public class GetReviewsFilterOrderCommand implements ICommand {

    private final ReviewService reviewService;

    public GetReviewsFilterOrderCommand(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        Long restaurantId = Long.parseLong(tokens.get(1));
        String order = tokens.get(4);
        Integer low = Integer.parseInt(tokens.get(2));
        Integer high = Integer.parseInt(tokens.get(3));
        List<Review> reviews = reviewService.getReviews(restaurantId, order, low, high);
        System.out.println(reviews);
    }

}
