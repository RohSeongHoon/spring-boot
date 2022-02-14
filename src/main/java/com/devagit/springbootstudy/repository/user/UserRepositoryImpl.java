package com.devagit.springbootstudy.repository.user;

import com.devagit.springbootstudy.domain.user.User;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final UserJpaRepository userJPARepository;

    public UserRepositoryImpl(UserJpaRepository userJPARepository) {
        this.userJPARepository = userJPARepository;
    }

    @Override
    public void deleteByUserId(String userId) {
        userJPARepository.deleteByUserId(userId);
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
    public User findByUserId(String userId) {
        return userJPARepository.findByUserId(userId);
    }

    @Override
    public User findByPhoneNumber(String userPhoneNumber) {
        return userJPARepository.findByPhoneNumber(userPhoneNumber);
    }


}
