package com.sda.mechanic.workshop.service;

import com.sda.mechanic.workshop.exceptions.UsernameAlreadyExistsException;
import com.sda.mechanic.workshop.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    public void registerUser(User user) throws UsernameAlreadyExistsException;

    List<User> getAllUsers();

    Optional<User> findUserByUsername(String loggedInUsername);
}
