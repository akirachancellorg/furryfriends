package com.entjava.furryfriends.controller;

import com.entjava.furryfriends.model.Snail;
import com.entjava.furryfriends.service.SnailService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/snail")
public class SnailController {

    private final SnailService snailService;

    public SnailController(SnailService snailService) {
        this.snailService = snailService;
    }

    @GetMapping
    public List<Snail> getAllSnails() {
        return snailService.findAllSnails();
    }

    @PostMapping
    public Snail createSnail(@RequestBody Snail snail) {
        return snailService.saveSnail(snail);
    }

    @DeleteMapping("/{id}")
    public void deleteSnail(@PathVariable Long id) {
        snailService.deleteSnail(id);
    }
}

