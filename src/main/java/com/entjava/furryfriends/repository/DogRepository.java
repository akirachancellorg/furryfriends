package com.entjava.furryfriends.repository;

import com.entjava.furryfriends.model.Dog;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long>
{
    // Add custom query methods specific to Dog
}

