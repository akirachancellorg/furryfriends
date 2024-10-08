package com.entjava.furryfriends.controller;

import com.entjava.furryfriends.model.Dog;
import com.entjava.furryfriends.service.DogService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/dogs")
public class DogController
{

    private final DogService dogService;

    public DogController(DogService dogService)
    {
        this.dogService = dogService;
    }

    @GetMapping
    public List<Dog> getAllDogs()
    {
        return dogService.findAllDogs();
    }

    @PostMapping
    public Dog createDog(@RequestBody Dog dog)
    {
        return dogService.saveDog(dog);
    }

    @DeleteMapping("/{id}")
    public void deleteDog(@PathVariable Long id)
    {
        dogService.deleteDog(id);
    }
}

