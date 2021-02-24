package com.project.give_back_in_good_hands.repository;

import com.project.give_back_in_good_hands.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
    List<User> findUserByEnabled(int enabled);
    User findUserById(Long id);
    User findUserByEmail(String email);
}
