package com.sda.mechanic.workshop.service;

public interface ISecurityService {
    String findLoggedInUsername();
    void autologin(String username, String password);
}
