package com.example.demo.services;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.example.demo.entities.Restaurant;
import com.example.demo.entities.Review;
import com.example.demo.repositories.IRestaurantRepository;
import com.example.demo.repositories.IReviewRepository;

public class ReviewService {
    private final IReviewRepository reviewRepository;
    private final IRestaurantRepository restaurantRepository;

    public ReviewService(IReviewRepository reviewRepository, IRestaurantRepository restaurantRepository) {
        this.reviewRepository = reviewRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public Review createReview(Long userId, Long restaurantId, Long rating, String listOfDishes, String description) {
        Review r = new Review(userId, restaurantId, rating, listOfDishes, description);
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();

        Review review = reviewRepository.save(r);
        
        restaurant.addReview(review);
        restaurant.updateTotalRating(review.getRating());
        restaurantRepository.update(restaurant);

        return review;
    }

    public List<Review> getReviews(Long restaurantId, String order, Integer low, Integer high) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();
        List<Review> reviews = restaurant.getReviews();
        Collections.sort(reviews, new Comparator<Review>() {

            @Override
            public int compare(Review arg0, Review arg1) {
                // TODO Auto-generated method stub
                return (int) (arg0.getRating() - arg1.getRating());
            }
        });

        if (low != null && high != null) {
            low--;
            high = Math.min(high, reviews.size());
            reviews = reviews.subList(low, high);
        }

        if(order.equals("RATING_DESC") || order == null) {
            Collections.sort(reviews, new Comparator<Review>() {

                @Override
                public int compare(Review arg0, Review arg1) {
                    // TODO Auto-generated method stub
                    return (int) (arg1.getRating() - arg0.getRating());
                }
                
            });
        } else {
            Collections.sort(reviews, new Comparator<Review>() {

                @Override
                public int compare(Review arg0, Review arg1) {
                    // TODO Auto-generated method stub
                    return (int) (arg0.getRating() - arg1.getRating());
                }
            });
        }
        
        return reviews;
    }
}
