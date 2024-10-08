package com.entjava.furryfriends.service;

import com.entjava.furryfriends.model.Ferret;
import com.entjava.furryfriends.repository.FerretRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FerretService {
    @Autowired
    private FerretRepository FerretRepository;

    public List<Ferret> findAllFerrets() {
        return FerretRepository.findAll();
    }

    public Ferret saveFerret(Ferret ferret) {
        return FerretRepository.save(ferret);
    }

    public void deleteFerret(Long id) {
        FerretRepository.deleteById(id);
    }

}

