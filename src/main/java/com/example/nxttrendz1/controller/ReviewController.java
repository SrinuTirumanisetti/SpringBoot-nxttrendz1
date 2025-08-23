package com.example.nxttrendz1.controller;

import com.example.nxttrendz1.model.Review;
import com.example.nxttrendz1.model.Product;
import com.example.nxttrendz1.repository.ReviewRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.nxttrendz1.service.ReviewJpaService;

@RestController
public class ReviewController {

    private final ReviewJpaService reviewJpaService;

    public ReviewController(ReviewJpaService reviewJpaService) {
        this.reviewJpaService = reviewJpaService;
    }

    @GetMapping("/products/reviews")
    public List<Review> getAllReviews() {
        return reviewJpaService.getAllReviews();
    }

    @PostMapping("/products/reviews")
    public Review addReview(@RequestBody Review review) {
        return reviewJpaService.addReview(review);
    }

    @GetMapping("/products/reviews/{reviewId}")
    public Review getProductReviews(@PathVariable("reviewId") int reviewId){
        return reviewJpaService.getProductReviews(reviewId);
    }

    @PutMapping("/products/reviews/{reviewId}")
    public Review updateReview(@PathVariable int reviewId, @RequestBody Review review) {
        return reviewJpaService.updateReview(reviewId, review);
    }

    @DeleteMapping("/products/reviews/{reviewId}")
    public void deleteReview(@PathVariable int reviewId) {
        reviewJpaService.deleteReview(reviewId);
    }


    @GetMapping("/reviews/{reviewId}/product")
    public Product getProductByReviewId(@PathVariable int reviewId) {
        return reviewJpaService.getProductByReviewId(reviewId);
    }
}

