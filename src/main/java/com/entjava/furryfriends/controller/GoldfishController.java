package com.entjava.furryfriends.controller;

import com.entjava.furryfriends.model.Goldfish;
import com.entjava.furryfriends.service.GoldfishService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/goldfish")
public class GoldfishController {

    private final GoldfishService goldfishService;

    public GoldfishController(GoldfishService goldfishService) { this.goldfishService = goldfishService; }

    @GetMapping
    public List<Goldfish> getAllGoldfish() { return goldfishService.findAllGoldfish(); }

    @PostMapping
    public Goldfish createGoldfish(@RequestBody Goldfish goldfish) {return goldfishService.savegoldfish(goldfish);}

    @DeleteMapping("/{id}")
    public void deleteGoldfish(@PathVariable Long id) {
        goldfishService.deleteGoldfish(id);
    }
}
