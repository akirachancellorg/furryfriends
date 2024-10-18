package com.entjava.furryfriends.service;

import com.entjava.furryfriends.model.Goldfish;
import com.entjava.furryfriends.repository.GoldfishRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional; // Import Optional

@Service
public class GoldfishService {
    @Autowired
    private GoldfishRepository goldfishRepository;

    public List<Goldfish> findAllGoldfish() {
        return goldfishRepository.findAll();
    }

    public Goldfish savegoldfish(Goldfish goldfish) {
        return goldfishRepository.save(goldfish);
    }

    public void deleteGoldfish(Long id) {
        goldfishRepository.deleteById(id);
    }

    // Add this method to find a goldfish by ID
    public Optional<Goldfish> findGoldfishById(Long id) {
        return goldfishRepository.findById(id);
    }
}
