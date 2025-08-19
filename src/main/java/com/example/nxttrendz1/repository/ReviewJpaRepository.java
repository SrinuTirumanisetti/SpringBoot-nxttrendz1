package com.example.nxttrendz1.repository;

import com.example.nxttrendz1.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewJpaRepository extends JpaRepository<Review, Integer> {
}
