package com.entjava.furryfriends.repository;

import com.entjava.furryfriends.model.Goldfish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoldfishRepository extends JpaRepository<Goldfish, Long> {
    // Add custom query methods specific to Goldfish
}
