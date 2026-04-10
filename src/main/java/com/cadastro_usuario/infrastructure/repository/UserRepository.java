package com.cadastro_usuario.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadastro_usuario.infrastructure.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    
}
