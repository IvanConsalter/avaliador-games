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

import com.ivanconsalter.avaliadorgames.dto.UserDTO;
import com.ivanconsalter.avaliadorgames.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<UserDTO> save(@RequestBody UserDTO userDTO) {
		UserDTO newUser = userService.save(userDTO);
		return ResponseEntity.ok(newUser);
	}
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<UserDTO> users = userService.findAll();
		return ResponseEntity.ok().body(users);
	}
	
	@GetMapping(path = "/{userId}")
	public ResponseEntity<UserDTO> findById(@PathVariable Long userId) {
		UserDTO userDTO = userService.findById(userId);
		return ResponseEntity.ok(userDTO);
	}

}
