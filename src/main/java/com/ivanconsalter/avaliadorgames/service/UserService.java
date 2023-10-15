package com.ivanconsalter.avaliadorgames.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivanconsalter.avaliadorgames.domain.User;
import com.ivanconsalter.avaliadorgames.dto.UserDTO;
import com.ivanconsalter.avaliadorgames.mapper.UserMapper;
import com.ivanconsalter.avaliadorgames.repository.UserRepository;
import com.ivanconsalter.avaliadorgames.service.exception.NotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserMapper userMapper;

	public List<UserDTO> findAll() {
		List<User> list = userRepository.findAll();
		return userMapper.toListDTO(list);
	}
	
	public UserDTO findById(Long userId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException(userId, User.class.getName()));
		return userMapper.toDTO(user);
	}

	public UserDTO save(UserDTO userDTO) {
		User user = userRepository.save(userMapper.toEntity(userDTO));
		return userMapper.toDTO(user);
	}
	

}
