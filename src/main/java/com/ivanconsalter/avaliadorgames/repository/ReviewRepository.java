package com.ivanconsalter.avaliadorgames.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ivanconsalter.avaliadorgames.domain.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{

}
