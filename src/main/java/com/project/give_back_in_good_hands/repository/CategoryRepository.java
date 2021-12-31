package com.project.give_back_in_good_hands.repository;

import com.project.give_back_in_good_hands.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
