package com.example.skill2ruralserver.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass // Ensure this annotation is present
public abstract class BaseEntity {
    @Id
    @GeneratedValue // Specify a strategy
    private Integer id;
}
