package com.entjava.furryfriends.service;

import com.entjava.furryfriends.model.Cat;
import com.entjava.furryfriends.repository.CatRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import com.entjava.furryfriends.model.PetType;

@Service
public class CatService {
    @Autowired
    private CatRepository catRepository;

    public List<Cat> findAllCats() {
        return catRepository.findAll();
    }

    public Cat saveCat(Cat cat) {
        cat.setType(PetType.CAT);
        return catRepository.save(cat);
    }

    public void deleteCat(Long id) {
        catRepository.deleteById(id);
    }

    public Cat updateCat(Long id, Cat cat) {
        Cat catToUpdate = catRepository.findById(id).get();
        // Pet Class
        catToUpdate.setName(cat.getName());
        catToUpdate.setAge(cat.getAge());
        // Cat Class
        catToUpdate.setColor(cat.getColor());
        catToUpdate.setIndoor(cat.getIndoor());
        
        return catRepository.save(catToUpdate);
    }
}

