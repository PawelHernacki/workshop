package com.sda.mechanic.workshop.service;

import com.sda.mechanic.workshop.model.User;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class SecurityService implements ISecurityService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsServiceImpl;

    @Autowired
    private IUserService userService;

    @Override
    public String findLoggedInUsername() {
        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        LoggerFactory.getLogger(getClass().getName()).info("User search: " + userDetails);
        if (userDetails instanceof UserDetails) {
//            LoggerFactory.getLogger(getClass().getName()).info("User proper type.");
            UserDetails user = (UserDetails) userDetails;
            return user.getUsername();
        }

//        LoggerFactory.getLogger(getClass().getName()).info("Username type not valid.");
        return null;
    }

    public Optional<User> getLoggedInUser(){
        String loggedInUsername = findLoggedInUsername();
        return userService.findUserByUsername(loggedInUsername);
    }

    @Override
    public void autologin(String username, String password) {
        UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                userDetails,
                password,
                userDetails.getAuthorities());

        authenticationManager.authenticate(token);

        if (token.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(token);
            Logger.getLogger(getClass().getName()).info("User logged in.");
        }
    }
}
