package com.entjava.furryfriends.controller;

import com.entjava.furryfriends.model.Dog;
import com.entjava.furryfriends.service.DogService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.entjava.furryfriends.model.ApiResponse;

@RestController
@RequestMapping("/dogs")
public class DogController {

    private final DogService dogService;

    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping
    public ApiResponse<List<Dog>> getAllDogs() {
        // Get the current authenticated user's username
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        // Fetch the list of dogs using the instance variable
        List<Dog> dogList = dogService.findAllDogs();

        // Create the response with data first and username second
        ApiResponse<List<Dog>> response = new ApiResponse<>(dogList, username);

        return response; // Return the ApiResponse object
    }

    @PostMapping
    public Dog createDog(@RequestBody Dog dog) {
        return dogService.saveDog(dog);
    }

    @DeleteMapping("/{id}")
    public void deleteDog(@PathVariable Long id) {
        dogService.deleteDog(id);
    }
}
