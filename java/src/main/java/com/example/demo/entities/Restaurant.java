package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private Long id;
    private String name;
    private List<Review> reviews;
    private Long totalRating;
    
    public Restaurant(String name, Long id) {
        this.id = id;
        this.name = name;
        reviews = new ArrayList<Review>();
        totalRating = 0L;
    }

    public Restaurant(String name) {
        this(name,null);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getTotalRating() {
        return totalRating;
    }
    
    public List<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    public void updateTotalRating(Long rating) {
        this.totalRating += rating;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Restaurant other = (Restaurant) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Restaurant [id=" + id + "]";
    }

}
