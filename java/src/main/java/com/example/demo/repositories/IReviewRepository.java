package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;
import com.example.demo.entities.Review;

public interface IReviewRepository {

    Review save(Review review);
    Optional<Review> findById(Long id);
    List<Review> findAll();
    Review update(Review review);
    void deleteById(Long id);
    boolean existsById(Long id);
    Long count();

}
