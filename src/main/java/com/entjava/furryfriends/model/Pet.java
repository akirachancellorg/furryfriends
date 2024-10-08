package com.entjava.furryfriends.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)  // Or SINGLE_TABLE / TABLE_PER_CLASS depending on your strategy
@Data  // Lombok to generate getters, setters, toString, etc.
public abstract class Pet
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

    @Enumerated(EnumType.STRING)
    private PetType type;  // Enum to differentiate pet types, if needed.
}
