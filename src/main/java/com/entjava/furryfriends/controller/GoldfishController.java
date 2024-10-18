package com.entjava.furryfriends.controller;

import com.entjava.furryfriends.model.Goldfish;
import com.entjava.furryfriends.service.GoldfishService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.entjava.furryfriends.model.ApiResponse;

@RestController
@RequestMapping("/goldfish")
public class GoldfishController {

    private final GoldfishService goldfishService;

    public GoldfishController(GoldfishService goldfishService) {
        this.goldfishService = goldfishService;
    }

    @GetMapping
    public ApiResponse<List<Goldfish>> getAllGoldfish() {
        // Get the current authenticated user's username
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        // Fetch the list of goldfish using the instance variable
        List<Goldfish> goldfishList = goldfishService.findAllGoldfish();

        // Create the response with data first and username second
        ApiResponse<List<Goldfish>> response = new ApiResponse<>(goldfishList, username);

        return response; // Return the ApiResponse object
    }

    @PostMapping
    public Goldfish createGoldfish(@RequestBody Goldfish goldfish) {
        return goldfishService.savegoldfish(goldfish);
    }

    @DeleteMapping("/{id}")
    public void deleteGoldfish(@PathVariable Long id) {
        goldfishService.deleteGoldfish(id);
    }
}
