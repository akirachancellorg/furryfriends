package com.entjava.furryfriends.service;

import com.entjava.furryfriends.model.Snail;
import com.entjava.furryfriends.repository.SnailRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional; // Import Optional

@Service
public class SnailService {
    @Autowired
    private SnailRepository snailRepository;

    public List<Snail> findAllSnails() {
        return snailRepository.findAll();
    }

    public Snail saveSnail(Snail snail) {
        return snailRepository.save(snail);
    }

    public void deleteSnail(Long id) {
        snailRepository.deleteById(id);
    }

    // New method to find a snail by its ID
    public Optional<Snail> findSnailById(Long id) {
        return snailRepository.findById(id); // Fetch the snail by ID
    }
}
