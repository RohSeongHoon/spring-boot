package com.devagit.springbootstudy.repository.user;

import com.devagit.springbootstudy.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;


public interface UserJpaRepository extends JpaRepository<User, String> {
    User findByUsername(String username);

    User findByUserId(String userId);

    @Transactional
    void deleteByUserId(String userId);

    User findByEmail(String email);
}
