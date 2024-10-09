package com.entjava.furryfriends.model;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Dog extends Pet {
    private String breed;
    private boolean trained;

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void setTrained(boolean trained) {
        this.trained = trained;
    }

    public boolean getTrained() {
        return trained;
    }
    
}
