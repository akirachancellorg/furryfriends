package com.entjava.furryfriends.repository;

import com.entjava.furryfriends.model.Hamster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HamsterRepository extends JpaRepository<Hamster, Long> {
    // Add custom query methods specific to Hamster
}
