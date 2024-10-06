package com.entjava.furryfriends.service;

import com.entjava.furryfriends.model.Bird;
import com.entjava.furryfriends.repository.BirdRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BirdService {

    private final BirdRepository birdRepository;

    public BirdService(BirdRepository birdRepository) {
        this.birdRepository = birdRepository;
    }

    public List<Bird> findAllBirds() {
        return birdRepository.findAll();
    }

    public Bird saveBird(Bird bird) {
        return birdRepository.save(bird);
    }

    public void deleteBird(Long id) {
        if (birdRepository.existsById(id))
        {
            birdRepository.deleteById(id);
        }
    }
}
