package com.sda.mechanic.workshop.service;

import com.sda.mechanic.workshop.exceptions.UsernameAlreadyExistsException;
import com.sda.mechanic.workshop.model.User;

public interface IUserService {
    public void registerUser(User user) throws UsernameAlreadyExistsException;
}
