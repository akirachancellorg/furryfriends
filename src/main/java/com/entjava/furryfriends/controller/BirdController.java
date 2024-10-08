package com.entjava.furryfriends.controller;

import com.entjava.furryfriends.model.Bird;
import com.entjava.furryfriends.service.BirdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/birds")
public class BirdController
{
    @Autowired
    private final BirdService BirdService;

    public BirdController(BirdService BirdService)
    {
        this.BirdService = BirdService;
    }

    @GetMapping
    public List<Bird> getAllBirds()
    {
        return BirdService.findAllBirds();
    }

    @PostMapping
    public Bird createBird(@RequestBody Bird bird)
    {
        Bird savedBird = BirdService.saveBird(bird);
        return ResponseEntity.ok(savedBird).getBody();
    }

    @DeleteMapping("/{id}")
    public void deleteBird(@PathVariable Long id)
    {
        BirdService.deleteBird(id);
    }
}
