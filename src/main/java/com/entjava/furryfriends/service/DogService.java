package com.entjava.furryfriends.service;

import com.entjava.furryfriends.model.Dog;
import com.entjava.furryfriends.repository.DogRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class DogService {
    @Autowired
    private DogRepository dogRepository;

    public List<Dog> findAllDogs() {
        return dogRepository.findAll();
    }

    public Dog saveDog(Dog dog) {return dogRepository.save(dog);}
    
    public Dog updateDog(Long id, Dog updatedDog) {
        Optional<Dog> optionalDog = dogRepository.findById(id);

        if (optionalDog.isPresent()) {
            Dog existingDog = optionalDog.get();

            // Update the existing dog's properties
            existingDog.setName(updatedDog.getName());
            existingDog.setBreed(updatedDog.getBreed());
            existingDog.setAge(updatedDog.getAge());

            // Save and return the updated dog
            return dogRepository.save(existingDog);
        } else {
            // If the dog does not exist, return null or throw an exception
            return null;
        }
    }

    public void deleteDog(Long id) {dogRepository.deleteById(id);}
}

