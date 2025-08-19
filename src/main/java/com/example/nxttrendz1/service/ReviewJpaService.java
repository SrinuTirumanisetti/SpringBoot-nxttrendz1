package com.example.nxttrendz1.service;

import com.example.nxttrendz1.model.Review;
import com.example.nxttrendz1.repository.ReviewRepository;
import com.example.nxttrendz1.repository.ReviewJpaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReviewJpaService implements ReviewRepository {

    private final ReviewJpaRepository reviewJpaRepository;

    public ReviewJpaService(ReviewJpaRepository reviewJpaRepository) {
        this.reviewJpaRepository = reviewJpaRepository;
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewJpaRepository.findAll();
    }

    @Override
    public Review addReview(Review review) {
        return reviewJpaRepository.save(review);
    }
}
