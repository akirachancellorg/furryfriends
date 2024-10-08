package com.entjava.furryfriends.service;

import com.entjava.furryfriends.model.Pet;
import com.entjava.furryfriends.repository.PetRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    @Autowired
    private PetRepository petRepository;

    public List<Pet> findAllPets()
    {
        return petRepository.findAll();
    }

    public Optional<Pet> findPetById(Long id)
    {
        return petRepository.findById(id);
    }

    public Pet savePet(Pet pet)
    {
        return petRepository.save(pet);
    }

    public void deletePet(Long id)
    {
        petRepository.deleteById(id);
    }
}

