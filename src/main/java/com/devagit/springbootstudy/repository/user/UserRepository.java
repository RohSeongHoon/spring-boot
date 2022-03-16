package com.devagit.springbootstudy.repository.user;

import com.devagit.springbootstudy.domain.User;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);

    List<User> findAll();

    Optional<User> findByUserId(String userId);

    User findByEmail(String email);

    void deleteByUserId(String userId);

    List<User> findByGenderAndUpdatedAtLessThanEqualOrderByUpdatedAtAsc(String gender, LocalDateTime updatedAt, Pageable pageable);
}
