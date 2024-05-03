package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Review;
import com.example.demo.services.ReviewService;

public class AddReviewCommand implements ICommand {

    private final ReviewService reviewService;

    public AddReviewCommand(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        Long rating = Long.parseLong(tokens.get(1));
        Long userId = Long.parseLong(tokens.get(2));
        Long restaurantId = Long.parseLong(tokens.get(3));
        String listOfDishes = tokens.get(4);
        String description = tokens.get(5);

        Review review = reviewService.createReview(userId, restaurantId, rating, listOfDishes, description);
        System.out.println(review + " added successfully for Restaurant [id=" + restaurantId + "] by User [id=" + userId + "]!");
    }

}
