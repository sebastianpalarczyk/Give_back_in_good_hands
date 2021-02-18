package com.project.give_back_in_good_hands.service;

import com.project.give_back_in_good_hands.domain.User;

import java.util.List;

public interface UserService {

    User findByUserName(String name);
    void saveUser(User user);
    List<User> findAllAdmins();
    User findUserById(Long id);
    void delete(User user);
    void saveAdmin(User user);
    List<User> findAllUsers();
    void save(User user);

}
