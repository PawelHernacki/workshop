package com.sda.mechanic.workshop.service;

import com.sda.mechanic.workshop.exceptions.UsernameAlreadyExistsException;
import com.sda.mechanic.workshop.model.User;
import com.sda.mechanic.workshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public void registerUser(User user) throws UsernameAlreadyExistsException {
        Optional<User> searchedDuplicate = userRepository.findByUsername(user.getUsername());
        if (searchedDuplicate.isPresent()) {
            throw new UsernameAlreadyExistsException();
        }

        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


}
