package com.ivanconsalter.avaliadorgames.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "DTO para criar um novo review")
public class ReviewDTO {
		
	@ApiModelProperty(notes = "ID único do review", hidden = true)
	private Long id;
	
	@ApiModelProperty(notes = "Avaliaço para o jogo", example = "4")
	private Integer rating;
	
    @ApiModelProperty(notes = "Comentário sobre o jogo", example = "Ótimo jogo, adorei...")
	private String comment;

    @ApiModelProperty(notes = "ID do usuário que criou o review", example = "1")
    private Long userId;
    
    @ApiModelProperty(notes = "ID do game onde será realizado o review", example = "1")
    private Long gameId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getGameId() {
		return gameId;
	}

	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}
    
}
