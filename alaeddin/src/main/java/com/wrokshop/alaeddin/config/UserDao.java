package com.wrokshop.alaeddin.config;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class UserDao implements UserDetailsService {

    private final static List<UserDetails> APPLICATION_USERS = Arrays.asList(
            new User("aladdin", "password",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"))),
            new User("user", "password",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")))
    );
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return APPLICATION_USERS
                .stream().filter(u -> u.getUsername().equals(username))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("username not founded"));
    }
}
