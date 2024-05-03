package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Review;
import com.example.demo.services.ReviewService;

public class GetReviewsCommand implements ICommand {

    private final ReviewService reviewService;

    public GetReviewsCommand(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        Long restaurantId = Long.parseLong(tokens.get(1));
        String order = tokens.get(2);
        List<Review> reviews = reviewService.getReviews(restaurantId, order, null, null);
        System.out.println(reviews);
    }

}
