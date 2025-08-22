package com.example.nxttrendz1.controller;

import com.example.nxttrendz1.model.Review;
import com.example.nxttrendz1.repository.ReviewRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.nxttrendz1.service.ReviewJpaService;

@RestController
@RequestMapping("/products")
public class ReviewController {

    private final ReviewJpaService reviewJpaService;

    public ReviewController(ReviewJpaService reviewJpaService) {
        this.reviewJpaService = reviewJpaService;
    }

    @GetMapping("/reviews")
    public List<Review> getAllReviews() {
        return reviewJpaService.getAllReviews();
    }

    @PostMapping("/reviews")
    public Review addReview(@RequestBody Review review) {
        return reviewJpaService.addReview(review);
    }

    @GetMapping("/reviews/{reviewId}")
    public Review getProductReviews(@PathVariable("reviewId") int reviewId){
        return reviewJpaService.getProductReviews(reviewId);
    }

    @PutMapping("/reviews/{reviewId}")
    public Review updateReview(@PathVariable int reviewId, @RequestBody Review review) {
        return reviewJpaService.updateReview(reviewId, review);
    }
}

