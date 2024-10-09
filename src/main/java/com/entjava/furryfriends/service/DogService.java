package com.entjava.furryfriends.service;

import com.entjava.furryfriends.model.Dog;
import com.entjava.furryfriends.repository.DogRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import com.entjava.furryfriends.model.PetType;

@Service
public class DogService {
    @Autowired
    private DogRepository dogRepository;

    public List<Dog> findAllDogs() {
        return dogRepository.findAll();
    }

    public Dog saveDog(Dog dog) {
        dog.setType(PetType.DOG);
        return dogRepository.save(dog);
    }

    public void deleteDog(Long id) {
        dogRepository.deleteById(id);
    }

    public Dog updateDog(Long id, Dog dog) {
        Dog dogToUpdate = dogRepository.findById(id).get();
        // Pet Class
        dogToUpdate.setName(dog.getName());
        dogToUpdate.setAge(dog.getAge());
        // Dog Class
        dogToUpdate.setBreed(dog.getBreed());
        dogToUpdate.setTrained(dog.getTrained());

        return dogRepository.save(dogToUpdate);
    }
}

