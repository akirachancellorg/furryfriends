package com.entjava.furryfriends.model;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Snail extends Pet {
    private String color;
    private boolean fast;
}
