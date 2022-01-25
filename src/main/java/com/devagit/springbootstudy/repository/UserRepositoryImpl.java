package com.devagit.springbootstudy.repository;

import com.devagit.springbootstudy.domain.user.User;
import com.devagit.springbootstudy.domain.user.UserRequest;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final UserJpaRepository userJPARepository;

    public UserRepositoryImpl(UserJpaRepository userJPARepository) {
        this.userJPARepository = userJPARepository;
    }

    @Override
    public User save(User user) {
        return userJPARepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userJPARepository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return userJPARepository.findByUsername(username);
    }

    @Override
    public User findByUserId(String userId) {
        return userJPARepository.findByUserId(userId);
    }
}
