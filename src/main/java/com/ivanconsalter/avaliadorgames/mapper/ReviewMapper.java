package com.ivanconsalter.avaliadorgames.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ivanconsalter.avaliadorgames.domain.Review;
import com.ivanconsalter.avaliadorgames.dto.ReviewDTO;

@Component
public class ReviewMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public ReviewMapper() { }

	public ReviewMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}
	
	public ReviewDTO toDTO(Review review) {
		return modelMapper.map(review, ReviewDTO.class);
	}
	
	public List<ReviewDTO> toListDTO(List<Review> list) {
		return list.stream().map(this::toDTO).collect(Collectors.toList()) ;
	}
	
	public Review toEntity(ReviewDTO reviewDTO) {
		return modelMapper.map(reviewDTO, Review.class);
	}
	

}
