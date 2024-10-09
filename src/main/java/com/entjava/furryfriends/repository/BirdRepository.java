package com.entjava.furryfriends.repository;

import com.entjava.furryfriends.model.Bird;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BirdRepository extends JpaRepository<Bird, Long> {
    // Add custom query methods specific to Bird
}
