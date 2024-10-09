package com.entjava.furryfriends.model;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Hamster extends Pet {
    private String color;
    private boolean isCute;

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setIsCute(boolean isCute) {
        this.isCute = isCute;
    }

    public boolean getIsCute() {
        return isCute;
    }
    
}
