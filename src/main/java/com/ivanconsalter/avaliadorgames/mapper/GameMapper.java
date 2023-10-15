package com.ivanconsalter.avaliadorgames.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ivanconsalter.avaliadorgames.domain.Game;
import com.ivanconsalter.avaliadorgames.dto.GameDTO;

@Component
public class GameMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public GameMapper() { }

	public GameMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}
	
	public GameDTO toDTO(Game game) {
		return modelMapper.map(game, GameDTO.class);
	}
	
	public List<GameDTO> toListDTO(List<Game> list) {
		return list.stream().map(this::toDTO).collect(Collectors.toList()) ;
	}
	
	public Game toEntity(GameDTO gameDTO) {
		return modelMapper.map(gameDTO, Game.class);
	}
	

}
