package com.example.cruduser.model;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Cars")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

public class Car {
    @Valid

    @NotNull(message = "Car Id should not be null")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long carId;

    @NotNull(message = "Model Name should not be null")
    private String modelName;

    @NotNull(message = "Year Of production should not be null")
    private String yearOfProduction;

    @NotNull(message = "User should not be null")
    @ManyToOne
    private User user;
}
