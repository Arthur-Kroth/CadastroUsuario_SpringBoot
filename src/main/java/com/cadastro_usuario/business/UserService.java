package com.cadastro_usuario.business;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cadastro_usuario.infrastructure.entity.User;
import com.cadastro_usuario.infrastructure.repository.UserRepository;

@Service
public class UserService {
    
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> createUser(User user) {
        repository.saveAndFlush(user);
        return listUsers();
    }

    public List<User> listUsers() {
        Sort sort = Sort.by("name").ascending();
        return repository.findAll(sort);
    }

    public User getUserByEmail(String email) {
        return repository.findByEmail(email).orElseThrow(
            () -> new RuntimeException("email not found")
        );
    }

    public List<User> deleteUserByEmail(String email) {
        repository.deleteByEmail(email);
        return listUsers();
    }

    public List<User> updateUserById(Integer id, User user) {
        User userEntity = repository.findById(id).orElseThrow(
            () -> new RuntimeException("User not found")
        );
        User userUpdated = User.builder()
             .email(user.getEmail() != null ? user.getEmail() : userEntity.getEmail())
             .name(user.getName() != null ? user.getName() : userEntity.getName())
             .id(userEntity.getId())
             .build();
        repository.saveAndFlush(userUpdated);
        return listUsers();
    }
}