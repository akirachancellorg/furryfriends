package com.entjava.furryfriends.controller;

import com.entjava.furryfriends.model.Hamster;
import com.entjava.furryfriends.service.HamsterService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/hamsters")
public class HamsterController {

    private final HamsterService hamsterService;

    public HamsterController(HamsterService hamsterService) {
        this.hamsterService = hamsterService;
    }

    @GetMapping
    public List<Hamster> getAllHamsters() {
        return hamsterService.findAllHamsters();
    }

    @PostMapping
    public Hamster createHamster(@RequestBody Hamster hamster) {
        return hamsterService.saveHamster(hamster);
    }

    @DeleteMapping("/{id}")
    public void deleteHamster(@PathVariable Long id) {
        hamsterService.deleteHamster(id);
    }

    @PatchMapping("/{id}")
    public Hamster updateHamster(@PathVariable Long id, @RequestBody Hamster hamster) {
        return hamsterService.updateHamster(id, hamster);
    }
}

