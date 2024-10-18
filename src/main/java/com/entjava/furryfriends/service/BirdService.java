package com.entjava.furryfriends.service;

import com.entjava.furryfriends.model.Bird;
import com.entjava.furryfriends.repository.BirdRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class BirdService {
    @Autowired
    private BirdRepository birdRepository;

    public List<Bird> findAllBirds() {
        return birdRepository.findAll();
    }

    public Bird saveBird(Bird bird) {
        return birdRepository.save(bird);
    }

    public void deleteBird(Long id) {
        birdRepository.deleteById(id);
    }
}
