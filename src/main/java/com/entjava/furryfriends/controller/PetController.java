package com.entjava.furryfriends.controller;

import com.entjava.furryfriends.model.Pet;
import com.entjava.furryfriends.service.PetService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.entjava.furryfriends.model.ApiResponse;

@RestController
@RequestMapping("/pets")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    public ApiResponse<List<Pet>> getAllPets() {
        // Get the current authenticated user's username
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        // Fetch the list of pets
        List<Pet> pets = petService.findAllPets();

        // Create the response with data first, username second
        ApiResponse<List<Pet>> response = new ApiResponse<>(pets, username);

        return response; // Return the ApiResponse object
    }

    @GetMapping("/{id}")
    public ApiResponse<Pet> getPetById(@PathVariable Long id) {
        // Get the current authenticated user's username
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        // Fetch the pet
        Pet pet = petService.findPetById(id).orElseThrow(() -> new RuntimeException("Pet not found"));

        // Create the response
        ApiResponse<Pet> response = new ApiResponse<>(pet, username);

        return response; // Return the ApiResponse object
    }

    @PostMapping
    public Pet createPet(@RequestBody Pet pet) {
        return petService.savePet(pet);
    }

    @DeleteMapping("/{id}")
    public void deletePet(@PathVariable Long id) {
        petService.deletePet(id);
    }
}
