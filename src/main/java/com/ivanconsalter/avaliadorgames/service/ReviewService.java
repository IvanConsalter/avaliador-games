package com.ivanconsalter.avaliadorgames.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivanconsalter.avaliadorgames.domain.Game;
import com.ivanconsalter.avaliadorgames.domain.Review;
import com.ivanconsalter.avaliadorgames.domain.User;
import com.ivanconsalter.avaliadorgames.dto.ReviewDTO;
import com.ivanconsalter.avaliadorgames.mapper.ReviewMapper;
import com.ivanconsalter.avaliadorgames.repository.GameRepository;
import com.ivanconsalter.avaliadorgames.repository.ReviewRepository;
import com.ivanconsalter.avaliadorgames.repository.UserRepository;
import com.ivanconsalter.avaliadorgames.service.exception.NotFoundException;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	private ReviewMapper reviewMapper;

	public List<ReviewDTO> findAll() {
		List<Review> reviews = reviewRepository.findAll();
		return reviewMapper.toListDTO(reviews);
	}
	
	public ReviewDTO findById(Long reviewId) {
		Review review = reviewRepository.findById(reviewId).orElseThrow(() -> new NotFoundException(reviewId, Review.class.getName()));
		return reviewMapper.toDTO(review);
	}

	public ReviewDTO save(ReviewDTO reviewDTO) {
		Long userId = reviewDTO.getUserId();
		User user = userRepository.findById(userId).orElseThrow( () -> new NotFoundException(userId, User.class.getName()));
		
		Long gameId = reviewDTO.getGameId();
		Game game = gameRepository.findById(gameId).orElseThrow( () -> new NotFoundException(gameId, Game.class.getName()));
		
		Review review = reviewMapper.toEntity(reviewDTO);
		review.setUser(user);
		review.setGame(game);
		review = reviewRepository.save(review);
		return reviewMapper.toDTO(review);
	}
}
