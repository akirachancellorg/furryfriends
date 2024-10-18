package com.entjava.furryfriends.service;

import com.entjava.furryfriends.model.Cat;
import com.entjava.furryfriends.model.Dog;
import com.entjava.furryfriends.repository.CatRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class CatService {
    @Autowired
    private CatRepository catRepository;

    public List<Cat> findAllCats() {
        return catRepository.findAll();
    }

    public Cat saveCat(Cat cat) {
        return catRepository.save(cat);
    }

    public void deleteCat(Long id) {
        catRepository.deleteById(id);
    }

    public Optional<Cat> findGoldfishById(Long id) {
        return catRepository.findById(id);
    }
}

