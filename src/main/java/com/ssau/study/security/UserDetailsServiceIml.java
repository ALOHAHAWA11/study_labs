package com.ssau.study.security;

import com.ssau.study.entity.User;
import com.ssau.study.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceIml implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceIml(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new
                UsernameNotFoundException("User doesn't exist"));
        return SecurityUser.fromUser(user);
    }
}
