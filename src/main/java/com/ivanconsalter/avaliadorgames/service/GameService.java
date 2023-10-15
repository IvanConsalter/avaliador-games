package com.ivanconsalter.avaliadorgames.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivanconsalter.avaliadorgames.domain.Game;
import com.ivanconsalter.avaliadorgames.domain.User;
import com.ivanconsalter.avaliadorgames.dto.GameDTO;
import com.ivanconsalter.avaliadorgames.mapper.GameMapper;
import com.ivanconsalter.avaliadorgames.repository.GameRepository;
import com.ivanconsalter.avaliadorgames.repository.UserRepository;
import com.ivanconsalter.avaliadorgames.service.exception.NotFoundException;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private GameMapper gameMapper;

	public List<GameDTO> findAll() {
		List<Game> games = gameRepository.findAll();
		return gameMapper.toListDTO(games);
	}
	
	public GameDTO findById(Long gameId) {
		Game game = gameRepository.findById(gameId).orElseThrow(() -> new NotFoundException(gameId, Game.class.getName()));
		return gameMapper.toDTO(game);
	}

	public GameDTO save(GameDTO gameDTO) {
		Long userId = gameDTO.getUserId();
		User user = userRepository.findById(userId).orElseThrow( () -> new NotFoundException(userId, User.class.getName()));
		Game game = gameMapper.toEntity(gameDTO);
		game.setUser(user);
		game.updateScore();
		game = gameRepository.save(game);
		return gameMapper.toDTO(game);
	}
}
