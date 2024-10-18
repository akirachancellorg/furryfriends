package com.entjava.furryfriends.service;

import com.entjava.furryfriends.model.Dog;
import com.entjava.furryfriends.repository.DogRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class DogService {
    @Autowired
    private DogRepository dogRepository;

    public List<Dog> findAllDogs() {
        return dogRepository.findAll();
    }

    public Dog saveDog(Dog dog) {return dogRepository.save(dog);}

    public void deleteDog(Long id) {dogRepository.deleteById(id);}
}

