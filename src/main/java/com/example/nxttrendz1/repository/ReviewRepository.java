package com.example.nxttrendz1.repository;

import com.example.nxttrendz1.model.Review;
import com.example.nxttrendz1.model.Product;
import java.util.List;

public interface ReviewRepository {
    List<Review> getAllReviews();
    Review addReview(Review review);
    Review getProductReviews(int reviewId);
    Review updateReview(int reviewId, Review updatedReview);
    void deleteReview(int reviewId);
    Product getProductByReviewId(int reviewId);
}
