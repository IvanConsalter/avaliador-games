package com.ivanconsalter.avaliadorgames.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "DTO para criar um novo jogo")
public class GameDTO {
	
	@ApiModelProperty(notes = "Título do jogo", example = "Nome do Jogo")
    private String title;

    @ApiModelProperty(notes = "Descrição do jogo", example = "Descrição do jogo")
    private String description;

    @ApiModelProperty(notes = "Data de lançamento do jogo no formato 'dd-MM-yyyy'", example = "15-10-2023")
    private String releaseDate;

    @ApiModelProperty(notes = "ID do usuário que criou o jogo", example = "1")
    private Long userId;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
    
}
