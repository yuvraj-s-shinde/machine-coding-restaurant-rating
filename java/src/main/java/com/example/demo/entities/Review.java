package com.example.demo.entities;

public class Review {
    private Long id;
    private Long userId;
    private Long restaurantId;
    private Long rating;
    private String listOfDishes;
    private String description;

    
    public Review(Long userId, Long restaurantId, Long rating, String listOfDishes, String description, Long id) {
        this.id = id;
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.rating = rating;
        this.listOfDishes = listOfDishes;
        this.description = description;
    }

    public Review(Long userId, Long restaurantId, Long rating, String listOfDishes, String description) {
        this(userId, restaurantId, rating, listOfDishes, description, null);
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public Long getRating() {
        return rating;
    }

    public String getListOfDishes() {
        return listOfDishes;
    }

    public String getDescription() {
        return description;
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
            Review other = (Review) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Review [id=" + id + "]" ;
    }

}
