package com.sda.mechanic.workshop.model.dto;

import com.sda.mechanic.workshop.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDto {
    private Long identifier;
    private String username;
    private Set<Role> setOfRoles;
}
