package com.sda.mechanic.workshop.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String registrationNumber;
    private String make; //marka
    private String model;

    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    private User owner;

    @OneToMany
    private List<ServiceOrder> orders;
}
