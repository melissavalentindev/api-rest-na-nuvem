package com.github.melissavalentindev.desafioapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.melissavalentindev.desafioapi.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
