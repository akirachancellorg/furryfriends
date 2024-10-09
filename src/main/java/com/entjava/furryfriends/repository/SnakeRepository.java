package com.entjava.furryfriends.repository;

import com.entjava.furryfriends.model.Snake;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SnakeRepository extends JpaRepository<Snake, Long>{
}
