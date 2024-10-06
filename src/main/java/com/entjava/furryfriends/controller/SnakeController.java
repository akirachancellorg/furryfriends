package com.entjava.furryfriends.controller;

import com.entjava.furryfriends.model.Snake;
import com.entjava.furryfriends.service.SnakeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/snakes")
public class SnakeController {

    private final SnakeService snakeService;

    public SnakeController(SnakeService snakeService) {this.snakeService = snakeService;}

    @GetMapping
    public List<Snake> getAllSnakes() {return snakeService.findAllSnakes();}

    @PostMapping
    public Snake createSnake(@RequestBody Snake snake) {return snakeService.saveSnake(snake);}

    @DeleteMapping("/{id}")
    public void deleteSnake(@PathVariable Long id) { snakeService.deleteSnake(id);}

}
