package com.ivanconsalter.avaliadorgames.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "DTO para criar um novo Usuário")
public class UserDTO {

	@ApiModelProperty(notes = "ID único do usuário", hidden = true)
	private Long id;
	
	@ApiModelProperty(notes = "Nome de usuário")
	private String username;
	
	@ApiModelProperty(notes = "Endereço de e-mail")
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
