package com.example.cruduser.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class PassportDTO {
    private String name;
    private String surname;

}
