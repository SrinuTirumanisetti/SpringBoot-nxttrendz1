package com.example.nxttrendz1.controller;

import com.example.nxttrendz1.model.Review;
import com.example.nxttrendz1.repository.ReviewRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ReviewController {

    private final ReviewRepository reviewRepository;

    public ReviewController(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @GetMapping("/products/reviews")
    public List<Review> getAllReviews() {
        return reviewRepository.getAllReviews();
    }
}
