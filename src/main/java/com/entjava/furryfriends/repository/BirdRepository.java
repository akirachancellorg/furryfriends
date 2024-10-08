package com.entjava.furryfriends.repository;

import com.entjava.furryfriends.model.Bird;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BirdRepository extends JpaRepository<Bird, Long>
{

}
