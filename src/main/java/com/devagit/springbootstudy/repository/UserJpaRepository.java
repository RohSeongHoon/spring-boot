package com.devagit.springbootstudy.repository;

import com.devagit.springbootstudy.domain.user.User;
import com.devagit.springbootstudy.domain.user.UserRequest;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserJpaRepository extends JpaRepository<User, String> {
    User findByUsername(String username);

    User findByUserId(String userId);

    User findByPhoneNumber(String userPhoneNumber);
}
