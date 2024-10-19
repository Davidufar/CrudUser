package com.example.cruduser.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Cars")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long carId;

    private String modelName;


    private String yearOfProduction;

    @ManyToOne
    private User user;
}
