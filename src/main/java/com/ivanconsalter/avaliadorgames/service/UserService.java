package com.ivanconsalter.avaliadorgames.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivanconsalter.avaliadorgames.domain.User;
import com.ivanconsalter.avaliadorgames.repository.UserRepository;
import com.ivanconsalter.avaliadorgames.service.exception.NotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById(Long userId) {
		return userRepository.findById(userId).orElseThrow(() -> new NotFoundException(userId, User.class.getName()));
	}

	public User save(User user) {
		return userRepository.save(user);
	}
	

}
