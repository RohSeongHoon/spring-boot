package com.devagit.springbootstudy.repository.user;

import com.devagit.springbootstudy.domain.User;
import com.devagit.springbootstudy.view.user.UserProfileView;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


public interface UserJpaRepository extends JpaRepository<User, String> {
    User findByUsername(String username);

    Optional<User> findByUserId(String userId);

    @Transactional
    void deleteByUserId(String userId);

    User findByEmail(String email);

    List<User> findByGenderAndUpdatedAtLessThanEqualOrderByUpdatedAtAsc(String gender, LocalDateTime updatedAt, Pageable pageable);

    List<UserProfileView> findByGenderAndBirthdayBetweenAndUpdatedAtLessThanEqualOrderByUpdatedAtAsc(String gender, LocalDate startDate, LocalDate endDate, LocalDateTime updatedAt, Pageable pageable);

    Optional<User> findByToken(String token);
}
