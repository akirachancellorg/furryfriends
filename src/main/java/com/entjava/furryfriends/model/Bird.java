package com.entjava.furryfriends.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Bird extends Pet
{
    private String color;
    private String species;
    private boolean flying;

}