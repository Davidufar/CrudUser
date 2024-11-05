package com.example.cruduser.model;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="Users")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class User {
    @Valid

    @NotNull(message = "id should not be null")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message = "name should not be null")
    private String name;

    @NotNull(message = "age should not be null")
    private int age;

    @NotNull(message = "email should not be null")
    private String email;

    @NotNull(message = "Cars should not be null")
    @OneToMany(mappedBy = "user")
    private List<Car> cars;

    @NotNull(message = "Passport should not be null")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Passports_id")
    private Passport passport;
}
