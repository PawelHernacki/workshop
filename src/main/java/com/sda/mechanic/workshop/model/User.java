package com.sda.mechanic.workshop.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "appuser")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    @ManyToMany(fetch =  FetchType.EAGER)
    private Set<Role> role;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "owner")
    private List<Car> carList;

}
