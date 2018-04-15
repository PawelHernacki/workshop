package com.sda.mechanic.workshop.service;

import com.sda.mechanic.workshop.model.User;
import com.sda.mechanic.workshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public void registerUser(User user) throws UsernameAlreadyExistsException {

        user.setPassword(encoder.encode(user.getPassword()));
        
        userRepository.save(user);
    }
}
