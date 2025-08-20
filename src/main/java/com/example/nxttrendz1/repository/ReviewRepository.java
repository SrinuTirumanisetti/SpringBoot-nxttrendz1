package com.example.nxttrendz1.repository;

import com.example.nxttrendz1.model.Review;
import java.util.List;

public interface ReviewRepository {
    List<Review> getAllReviews();
    Review addReview(Review review);
    Review getProductReviews(int reviewId);
}
