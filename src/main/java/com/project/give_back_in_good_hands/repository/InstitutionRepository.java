package com.project.give_back_in_good_hands.repository;

import com.project.give_back_in_good_hands.domain.Institution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstitutionRepository extends JpaRepository<Institution, Long> {
}
