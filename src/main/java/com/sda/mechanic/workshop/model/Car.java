package com.sda.mechanic.workshop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    @ManyToOne(cascade = CascadeType.PERSIST)
    private User owner;

    @OneToMany(mappedBy = "car")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<ServiceOrder> orders;

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
