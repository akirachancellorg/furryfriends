package com.entjava.furryfriends.controller;

import com.entjava.furryfriends.model.Pet;
import com.entjava.furryfriends.service.PetService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.security.core.Authentication;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/pets")
public class PetController {
    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    public Map<String,Object> getAllPets(Authentication authentication)
    {
        List<Pet> pets = petService.findAllPets();

        Map<String,Object> map = new HashMap<>();
        map.put("message", "Authentication successful");
        map.put("user", authentication.getName());
        map.put("pets",pets);

        return map;
    }

    @GetMapping("/{id}")
    public Pet getPetById(@PathVariable Long id) {
        return petService.findPetById(id).orElseThrow(() -> new RuntimeException("Pet not found"));
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

