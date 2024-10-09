package com.entjava.furryfriends.service;

import com.entjava.furryfriends.model.Goldfish;
import com.entjava.furryfriends.repository.GoldfishRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

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
}

