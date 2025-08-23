package com.example.nxttrendz1.service;

import com.example.nxttrendz1.model.Review;
import com.example.nxttrendz1.model.Product;
import com.example.nxttrendz1.repository.ReviewRepository;
import com.example.nxttrendz1.repository.ReviewJpaRepository;
import com.example.nxttrendz1.repository.ProductJpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ReviewJpaService implements ReviewRepository {

    private final ReviewJpaRepository reviewJpaRepository;
    private final ProductJpaRepository productJpaRepository;

    @Autowired
    public ReviewJpaService(ReviewJpaRepository reviewJpaRepository, ProductJpaRepository productJpaRepository) {
        this.reviewJpaRepository = reviewJpaRepository;
        this.productJpaRepository = productJpaRepository;
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewJpaRepository.findAll();
    }

    @Override
    public Review addReview(Review review) {
        Product product = review.getProduct();
        int productId = product.getProductId();

        Product completeProduct = productJpaRepository.findById(productId)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Product not found with id " + productId));

        review.setProduct(completeProduct);
        return reviewJpaRepository.save(review);
    }

    @Override
    public Review getProductReviews(int reviewId) {
        return reviewJpaRepository.findById(reviewId)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Review not found with id " + reviewId));
    }

    @Override
    public Review updateReview(int reviewId, Review updatedReview) {
        Review existingReview = reviewJpaRepository.findById(reviewId)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Review not found with id " + reviewId));

        existingReview.setReviewContent(updatedReview.getReviewContent());
        existingReview.setRating(updatedReview.getRating());

        if (updatedReview.getProduct() != null) {
            int productId = updatedReview.getProduct().getProductId();
            Product product = productJpaRepository.findById(productId)
                .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Product not found with id " + productId));
            existingReview.setProduct(product);
        }

        return reviewJpaRepository.save(existingReview);
    }

    @Override
    public void deleteReview(int reviewId) {
        Review existingReview = reviewJpaRepository.findById(reviewId)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Review not found with id " + reviewId));

        reviewJpaRepository.delete(existingReview);
    }

    @Override
    public Product getProductByReviewId(int reviewId) {
        Review review = reviewJpaRepository.findById(reviewId)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Review not found with id " + reviewId));
        return review.getProduct();
    }
}
