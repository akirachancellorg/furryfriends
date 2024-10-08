package com.entjava.furryfriends.controller;

import com.entjava.furryfriends.model.Pet;
import com.entjava.furryfriends.service.PetService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService)
    {
        this.petService = petService;
    }

    @GetMapping
    public List<Pet> getAllPets()
    {
        return petService.findAllPets();
    }

    @GetMapping("/{id}")
    public Pet getPetById(@PathVariable Long id) {
        return petService.findPetById(id).orElseThrow(() -> new RuntimeException("Pet not found"));
    }

    @PostMapping
    public Pet createPet(@RequestBody Pet pet)
    {
        return petService.savePet(pet);
    }

    @DeleteMapping("/{id}")
    public void deletePet(@PathVariable Long id)
    {
        petService.deletePet(id);
    }
}

