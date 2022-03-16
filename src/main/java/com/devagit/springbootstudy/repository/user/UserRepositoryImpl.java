package com.devagit.springbootstudy.repository.user;

import com.devagit.springbootstudy.domain.User;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
    public List<User> findByGenderAndUpdatedAtLessThanEqualOrderByUpdatedAtAsc(String gender, LocalDateTime updatedAt, Pageable pageable) {
        return userJPARepository.findByGenderAndUpdatedAtLessThanEqualOrderByUpdatedAtAsc(gender,updatedAt,pageable);
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
    public Optional<User> findByUserId(String userId) {
        return userJPARepository.findByUserId(userId);
    }

    @Override
    public User findByEmail(String email) {
        return userJPARepository.findByEmail(email);
    }


}
