package com.project.give_back_in_good_hands.repository;

import com.project.give_back_in_good_hands.domain.Donation;
import com.project.give_back_in_good_hands.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DonationRepository extends JpaRepository<Donation, Long> {

    List<Donation> findAllByUser(User user);
}
