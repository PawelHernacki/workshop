package com.sda.mechanic.workshop.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class ServiceOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate dateSubmitted;
    private String description;
    private boolean completed;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Car car;

    @Override
    public String toString() {
        return "ServiceOrder{" +
                "id=" + id +
                ", dateSubmitted=" + dateSubmitted +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                '}';
    }
}
