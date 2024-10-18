package com.entjava.furryfriends.controller;

import com.entjava.furryfriends.model.Dog;
import com.entjava.furryfriends.service.DogService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.security.core.Authentication;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/dogs")
public class DogController {

    private final DogService dogService;

    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping
    public Map<String,Object> getAllDogs(Authentication authentication)
    {
        List<Dog> dogs = dogService.findAllDogs();

        Map<String,Object> map = new HashMap<>();
        map.put("message", "Authentication successful");
        map.put("user", authentication.getName());
        map.put("dogs", dogs);

        return map;
    }

    @PostMapping
    public Dog createDog(@RequestBody Dog dog) {
        return dogService.saveDog(dog);
    }

    @DeleteMapping("/{id}")
    public void deleteDog(@PathVariable Long id) {
        dogService.deleteDog(id);
    }

    @PutMapping("/{id}")
    public Dog updateDog(@PathVariable Long id, @RequestBody Dog updatedDog) {
        Dog existingDog = dogService.findAllDogs().stream()
                .filter(dog -> dog.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (existingDog != null) {
            existingDog.setName(updatedDog.getName());
            existingDog.setBreed(updatedDog.getBreed());
            existingDog.setAge(updatedDog.getAge());
            existingDog.setTrained(updatedDog.isTrained());
            return dogService.saveDog(existingDog);
        }

        return null;

    }

}

