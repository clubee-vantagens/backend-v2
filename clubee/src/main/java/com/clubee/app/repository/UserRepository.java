package com.clubee.app.repository;

import com.clubee.domain.entity.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findByEmail(String email);
    Optional<User> findById(Long id);
}
