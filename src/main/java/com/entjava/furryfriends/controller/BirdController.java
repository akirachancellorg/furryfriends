package com.entjava.furryfriends.controller;

import com.entjava.furryfriends.model.Bird;
import com.entjava.furryfriends.service.BirdService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.security.core.Authentication;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/birds")

public class BirdController {
    private final BirdService birdService;


    public BirdController(BirdService birdService) {this.birdService = birdService;}

    @GetMapping
    public Map<String,Object> getAllBirds(Authentication authentication)
    {
        List<Bird> birds = birdService.findAllBirds();

        Map<String,Object> map = new HashMap<>();
        map.put("message", "Authentication successful");
        map.put("user", authentication.getName());
        map.put("birds", birds);

        return map;
    }

    @PostMapping
    public Bird createBird(@RequestBody Bird bird) {
        return birdService.saveBird(bird);}

    @DeleteMapping("/{id}")
    public void deleteBird(@PathVariable Long id) {
        birdService.deleteBird(id);
    }

    @PutMapping("/{id}")
    public Bird updateBird(@PathVariable Long id, @RequestBody Bird updatedBird) {
        Bird existingBird = birdService.findAllBirds().stream().
                filter(bird -> bird.getId().equals(id)).
                findFirst().
                orElse(null);

        if (existingBird != null) {
            existingBird.setName(updatedBird.getName());
            existingBird.setAge(updatedBird.getAge());
            existingBird.setFlightless(updatedBird.isFlightless());
            existingBird.setSpecies(updatedBird.getSpecies());
            return birdService.saveBird(existingBird);
        }

        return null;
    }
}
