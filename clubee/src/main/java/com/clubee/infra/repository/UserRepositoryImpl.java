package com.clubee.infra.repository;

import com.clubee.app.repository.UserRepository;
import com.clubee.domain.entity.User;
import com.clubee.infra.database.model.UserJPARepository;
import com.clubee.infra.database.model.UserModel;
import com.clubee.infra.exception.general.EntityNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final UserJPARepository userJPARepository;

    public UserRepositoryImpl(UserJPARepository userJPARepository) {
        this.userJPARepository = userJPARepository;
    }

    @Override
    public Optional<User> findByEmail(String email) {

        Optional<UserModel> userModel = this.userJPARepository.findByEmail(email);
        if (userModel.isEmpty()) throw new EntityNotFoundException("User not found!");
        return Optional.empty();
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }
}
