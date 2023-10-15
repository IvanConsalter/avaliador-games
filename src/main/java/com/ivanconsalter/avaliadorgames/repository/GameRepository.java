package com.ivanconsalter.avaliadorgames.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ivanconsalter.avaliadorgames.domain.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long>{

}
