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

    @PutMapping("/{id}")
    public Snake updateSnake(@PathVariable Long id, @RequestBody Snake updatedSnake) {
        Snake existingSnake = snakeService.findAllSnakes().stream()
                .filter(snake -> snake.getId().equals(id))
                .findFirst()
                .orElse(null);

        if(existingSnake != null) {
            existingSnake.setName(updatedSnake.getName());
            existingSnake.setAge(updatedSnake.getAge());
            existingSnake.setSpecies(updatedSnake.getSpecies());
            existingSnake.setVenomous(updatedSnake.isVenomous());
            return snakeService.saveSnake(existingSnake);
        }

        return null;
    }

}
