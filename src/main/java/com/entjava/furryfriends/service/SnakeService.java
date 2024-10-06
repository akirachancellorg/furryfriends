package com.entjava.furryfriends.service;

import com.entjava.furryfriends.model.Snake;
import com.entjava.furryfriends.repository.SnakeRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class SnakeService {
    @Autowired
    private SnakeRepository snakerepository;

    public List<Snake> findAllSnakes() { return snakerepository.findAll(); }

    public Snake saveSnake(Snake snake) { return snakerepository.save(snake); }

    public void deleteSnake(Long id) { snakerepository.deleteById(id); }
}
