package com.project.give_back_in_good_hands.service;

import com.project.give_back_in_good_hands.domain.Role;
import com.project.give_back_in_good_hands.domain.User;
import com.project.give_back_in_good_hands.domain.VerificationToken;
import com.project.give_back_in_good_hands.repository.RoleRepository;
import com.project.give_back_in_good_hands.repository.UserRepository;
import com.project.give_back_in_good_hands.repository.VerificationTokenRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final VerificationTokenRepository verificationTokenRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
                           BCryptPasswordEncoder passwordEncoder, VerificationTokenRepository verificationTokenRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;

        this.verificationTokenRepository = verificationTokenRepository;
    }

    @Override
    public User findByUserName(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(1);
        userRepository.save(user);
    }

    @Override
    public void saveAdmin(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(2);
        Role userRole = roleRepository.findByName("ROLE_ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    @Override
    public List<User> findAllAdmins(){
        return userRepository.findUserByEnabled(2);
    }

    @Override
    public List<User> findAllUsers(){
        return userRepository.findUserByEnabled(1);
    }

    @Override
    public User findUserById(Long id){
        return userRepository.findUserById(id);
    }

    @Override
    public void delete(User user){
        userRepository.delete(user);
    }

    @Override
    public void save(User user){
        userRepository.save(user);
    }

    @Override
    public void createVerificationTokenForUser( User user, String token) {
        final VerificationToken myToken = new VerificationToken(token, user);
        verificationTokenRepository.save(myToken);
    }

    @Override
    public VerificationToken findByToken(String token) {
        return verificationTokenRepository.findByToken(token);
    }

    @Override
    public void roleForUser(User user) {
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    @Override
    public VerificationToken createToken() {
        VerificationToken token = new VerificationToken();
        token.setToken(UUID.randomUUID().toString());
        return token;
    }

    @Override
    public boolean checkToken(VerificationToken token) {
        Calendar calendar = Calendar.getInstance();
        return token.getExpiryDate().getTime() - calendar.getTime().getTime() > 0;
    }

    @Override
    public VerificationToken generateNewVerificationToken(String existingVerificationToken) {
        VerificationToken token = verificationTokenRepository.findByToken(existingVerificationToken);
        token.updateToken(UUID.randomUUID()
                .toString());
        verificationTokenRepository.save(token);
        return token;
    }

    @Override
    public VerificationToken findByUser(User user){
        return verificationTokenRepository.findByUser(user);
    }


    @Override
    public void deleteToken(VerificationToken token) {
         verificationTokenRepository.delete(token);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

}
