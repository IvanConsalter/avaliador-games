package com.ivanconsalter.avaliadorgames.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ivanconsalter.avaliadorgames.domain.Game;
import com.ivanconsalter.avaliadorgames.dto.GameDTO;
import com.ivanconsalter.avaliadorgames.service.GameService;

@RestController
@RequestMapping("games")
public class GameController {

	@Autowired
	private GameService gameService;
	
	@PostMapping
	public ResponseEntity<Game> save(GameDTO gameDTO) {
		Game newGame = gameService.save(gameDTO);
		return ResponseEntity.ok(newGame);
	}
	
	@GetMapping
	public ResponseEntity<List<Game>> findAll() {
		List<Game> games = gameService.findAll();
		return ResponseEntity.ok().body(games);
	}
	
	@GetMapping(path = "/{gameId}")
	public ResponseEntity<Game> findById(@PathVariable Long gameId) {
		Game game = gameService.findById(gameId);
		return ResponseEntity.ok(game);
	}
	
}
