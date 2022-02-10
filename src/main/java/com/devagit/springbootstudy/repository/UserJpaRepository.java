package com.devagit.springbootstudy.repository;

import com.devagit.springbootstudy.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;


public interface UserJpaRepository extends JpaRepository<User, String> {
    User findByUsername(String username);

    User findByUserId(String userId);

    User findByPhoneNumber(String userPhoneNumber);



    @Transactional
    void deleteByUserId(String userId);
}
