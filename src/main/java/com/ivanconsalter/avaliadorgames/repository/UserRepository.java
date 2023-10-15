package com.ivanconsalter.avaliadorgames.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ivanconsalter.avaliadorgames.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
