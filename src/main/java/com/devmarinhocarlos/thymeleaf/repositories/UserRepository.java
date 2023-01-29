package com.devmarinhocarlos.thymeleaf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devmarinhocarlos.thymeleaf.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
