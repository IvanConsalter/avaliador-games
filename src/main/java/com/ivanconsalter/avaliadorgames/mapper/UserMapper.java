package com.ivanconsalter.avaliadorgames.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ivanconsalter.avaliadorgames.domain.User;
import com.ivanconsalter.avaliadorgames.dto.UserDTO;

@Component
public class UserMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public UserMapper() { }

	public UserMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}
	
	public UserDTO toDTO(User user) {
		return modelMapper.map(user, UserDTO.class);
	}
	
	public List<UserDTO> toListDTO(List<User> list) {
		return list.stream().map(this::toDTO).collect(Collectors.toList()) ;
	}
	
	public User toEntity(UserDTO userDTO) {
		return modelMapper.map(userDTO, User.class);
	}
	

}
