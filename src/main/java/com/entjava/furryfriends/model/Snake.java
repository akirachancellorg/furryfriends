package com.entjava.furryfriends.model;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Snake extends Pet {
    private String species;
    private boolean isVenomous;
}
