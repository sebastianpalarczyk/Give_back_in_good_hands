package com.project.give_back_in_good_hands.service;

import com.project.give_back_in_good_hands.domain.User;
import com.project.give_back_in_good_hands.domain.VerificationToken;

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
    void createVerificationTokenForUser( User user, String token);
    VerificationToken findByToken(String token);
    void roleForUser(User user);
    VerificationToken createToken();
    boolean checkToken(VerificationToken token);
    VerificationToken generateNewVerificationToken(String existingVerificationToken);
    VerificationToken findByUser(User user);
    void deleteToken(VerificationToken token);
    User findUserByEmail(String email);
}
