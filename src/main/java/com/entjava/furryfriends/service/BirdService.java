package com.entjava.furryfriends.service;

import com.entjava.furryfriends.model.Bird;
import com.entjava.furryfriends.repository.BirdRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import com.entjava.furryfriends.model.PetType;

@Service
public class BirdService {
    @Autowired
    private BirdRepository birdRepository;

    public List<Bird> findAllBirds() {
        return birdRepository.findAll();
    }

    public Bird saveBird(Bird bird) {
        bird.setType(PetType.BIRD);
        return birdRepository.save(bird);
    }
    // asdasd
    public void deleteBird(Long id) {
        birdRepository.deleteById(id);
    }

    public Bird updateBird(Long id, Bird bird) {
        Bird birdToUpdate = birdRepository.findById(id).get();
        // Pet Class
        birdToUpdate.setName(bird.getName());
        birdToUpdate.setAge(bird.getAge());
        // Bird Class
        birdToUpdate.setColor(bird.getColor());
        birdToUpdate.setCanFly(bird.getCanFly());
        
        return birdRepository.save(birdToUpdate);
    }
}

