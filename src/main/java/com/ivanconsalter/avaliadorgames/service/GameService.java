package com.ivanconsalter.avaliadorgames.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivanconsalter.avaliadorgames.domain.Game;
import com.ivanconsalter.avaliadorgames.domain.User;
import com.ivanconsalter.avaliadorgames.dto.GameDTO;
import com.ivanconsalter.avaliadorgames.repository.GameRepository;
import com.ivanconsalter.avaliadorgames.repository.UserRepository;
import com.ivanconsalter.avaliadorgames.service.exception.NotFoundException;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	private UserRepository userRepository;

	public List<Game> findAll() {
		return gameRepository.findAll();
	}
	
	public Game findById(Long gameId) {
		return gameRepository.findById(gameId).orElseThrow(() -> new NotFoundException(gameId, Game.class.getName()));
	}

	public Game save(GameDTO gameDTO) {
		Long userId = gameDTO.getUserId();
		User user = userRepository.findById(userId).orElseThrow( () -> new NotFoundException(userId, User.class.getName()));
		Game game = new Game();
		game.setTitle(gameDTO.getTitle());
		game.setDescription(gameDTO.getDescription());
		game.setReleaseDate(gameDTO.getReleaseDate());
		game.setUser(user);
		return gameRepository.save(game);
	}
}
