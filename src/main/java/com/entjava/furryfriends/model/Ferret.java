package com.entjava.furryfriends.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Ferret extends Pet
{
    private String size;
    private boolean trained;

}