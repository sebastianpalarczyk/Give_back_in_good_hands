package com.project.give_back_in_good_hands.service;

import com.project.give_back_in_good_hands.domain.Role;
import com.project.give_back_in_good_hands.domain.User;
import com.project.give_back_in_good_hands.repository.RoleRepository;
import com.project.give_back_in_good_hands.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final String NOREPLY_ADDRESS = "palarczykhsse@gmail.com";

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
                           BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User findByUserName(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(1);
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
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


}
