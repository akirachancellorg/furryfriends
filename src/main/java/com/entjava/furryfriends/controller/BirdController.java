package com.entjava.furryfriends.controller;

import com.entjava.furryfriends.model.Bird;
import com.entjava.furryfriends.model.Cat;
import com.entjava.furryfriends.service.BirdService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/birds")

public class BirdController {
    private final BirdService birdService;


    public BirdController(BirdService birdService) {this.birdService = birdService;}

    @GetMapping
    public List<Bird> getAllBirds() {
        return birdService.findAllBirds();
    }

    @PostMapping
    public Bird createBird(@RequestBody Bird bird) {
        return birdService.saveBird(bird);
    }

    @DeleteMapping("/{id}")
    public void deleteBird(@PathVariable Long id) {
        birdService.deleteBird(id);
    }
}
