package com.project.give_back_in_good_hands.repository;

import com.project.give_back_in_good_hands.domain.User;
import com.project.give_back_in_good_hands.domain.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {

    VerificationToken findByToken(String token);
    VerificationToken findByUser(User user);
}
