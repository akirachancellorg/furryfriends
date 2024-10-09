package com.entjava.furryfriends.service;

import com.entjava.furryfriends.model.Hamster;
import com.entjava.furryfriends.repository.HamsterRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import com.entjava.furryfriends.model.PetType;

@Service
public class HamsterService {
    @Autowired
    private HamsterRepository hamsterRepository;

    public List<Hamster> findAllHamsters() {
        return hamsterRepository.findAll();
    }

    public Hamster saveHamster(Hamster hamster) {
        hamster.setType(PetType.HAMSTER);
        return hamsterRepository.save(hamster);
    }

    public void deleteHamster(Long id) {
        hamsterRepository.deleteById(id);
    }

    public Hamster updateHamster(Long id, Hamster hamster) {
        Hamster hamsterToUpdate = hamsterRepository.findById(id).get();
        // Pet Class
        hamsterToUpdate.setName(hamster.getName());
        hamsterToUpdate.setAge(hamster.getAge());
        // Hamster Class
        hamsterToUpdate.setColor(hamster.getColor());
        hamsterToUpdate.setIsCute(hamster.getIsCute());
        
        return hamsterRepository.save(hamsterToUpdate);
    }
}

