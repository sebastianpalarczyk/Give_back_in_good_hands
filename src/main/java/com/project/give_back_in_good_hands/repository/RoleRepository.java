package com.project.give_back_in_good_hands.repository;

import com.project.give_back_in_good_hands.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByName(String name);
}
