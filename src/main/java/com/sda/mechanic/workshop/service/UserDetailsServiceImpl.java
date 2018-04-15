package com.sda.mechanic.workshop.service;

import com.sda.mechanic.workshop.model.User;
import com.sda.mechanic.workshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> result = userRepository.findByUsername(username);

        if (result.isPresent()) {
            Logger.getLogger(getClass().getName()).info("User found!");
            User user = result.get();

            Set<GrantedAuthority> authorities = user.getRole()
                    .stream()
                    .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
                    .collect(Collectors.toSet());

            Logger.getLogger(getClass().getName()).info("User authorities: " + authorities);

            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(),
                    user.getPassword(),
                    authorities);
        }

        Logger.getLogger(getClass().getName()).info("User not found!");
        throw new UsernameNotFoundException("Nie znaleziono!");
    }
}
