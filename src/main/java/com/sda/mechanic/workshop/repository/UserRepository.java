package com.sda.mechanic.workshop.repository;

import com.sda.mechanic.workshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
