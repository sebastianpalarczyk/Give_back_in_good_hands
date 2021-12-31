package com.project.give_back_in_good_hands.service;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CurrentUser extends User {

    private final com.project.give_back_in_good_hands.domain.User user;

    public CurrentUser(String username, String password,
                       Collection<? extends GrantedAuthority> authorities,
                       com.project.give_back_in_good_hands.domain.User user) {
        super(username, password, authorities);
        this.user = user;
    }

    public com.project.give_back_in_good_hands.domain.User getUser() {
        return user;
    }
}
