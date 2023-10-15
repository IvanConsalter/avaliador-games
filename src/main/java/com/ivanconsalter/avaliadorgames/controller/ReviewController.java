package com.ivanconsalter.avaliadorgames.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ivanconsalter.avaliadorgames.dto.ReviewDTO;
import com.ivanconsalter.avaliadorgames.service.ReviewService;

@RestController
@RequestMapping("reviews")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	
	@PostMapping
	public ResponseEntity<ReviewDTO> save(@RequestBody ReviewDTO reviewDTO) {
		ReviewDTO newReview = reviewService.save(reviewDTO);
		return ResponseEntity.ok(newReview);
	}
	
	@GetMapping
	public ResponseEntity<List<ReviewDTO>> findAll() {
		List<ReviewDTO> reviewDTOs = reviewService.findAll();
		return ResponseEntity.ok().body(reviewDTOs);
	}
	
	@GetMapping(path = "/{reviewId}")
	public ResponseEntity<ReviewDTO> findById(@PathVariable Long reviewId) {
		ReviewDTO reviewDTO = reviewService.findById(reviewId);
		return ResponseEntity.ok(reviewDTO);
	}
	
}
