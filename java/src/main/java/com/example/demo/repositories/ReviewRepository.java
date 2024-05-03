package com.example.demo.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.demo.entities.Review;

public class ReviewRepository implements IReviewRepository {
    Map<Long, Review> reviewMap;
    private Long autoIncrement=1L;
    
    public ReviewRepository() {
        this.reviewMap = new HashMap<Long, Review>();
    }

    @Override
    public Review save(Review review) {
        // TODO Auto-generated method stub
        Review r = new Review(review.getUserId(), review.getRestaurantId(), review.getRating(), review.getListOfDishes(), review.getDescription(), autoIncrement);
        reviewMap.put(autoIncrement,r);
        ++autoIncrement;
        return r;
    }

    @Override
    public Optional<Review> findById(Long id) {
        // TODO Auto-generated method stub
        return Optional.ofNullable(reviewMap.get(id));
    }

    @Override
    public List<Review> findAll() {
        // TODO Auto-generated method stub
        return reviewMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public Review update(Review review) {
        // TODO Auto-generated method stub
        return reviewMap.put(review.getId(), review);
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        reviewMap.remove(id);
    }

    @Override
    public boolean existsById(Long id) {
        // TODO Auto-generated method stub
        return reviewMap.containsKey(id);
    }

    @Override
    public Long count() {
        // TODO Auto-generated method stub
        return (long) reviewMap.values().size();
    }
}
