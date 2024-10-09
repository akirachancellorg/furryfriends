package com.entjava.furryfriends.repository;

import com.entjava.furryfriends.model.Snail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SnailRepository extends JpaRepository<Snail, Long> {
    // Add custom query methods specific to Goldfish
}
