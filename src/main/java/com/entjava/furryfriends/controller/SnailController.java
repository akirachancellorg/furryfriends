package com.entjava.furryfriends.controller;

import com.entjava.furryfriends.model.Snail;
import com.entjava.furryfriends.service.SnailService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.entjava.furryfriends.model.ApiResponse;

@RestController
@RequestMapping("/snails")
public class SnailController {

    private final SnailService snailService;

    public SnailController(SnailService snailService) {
        this.snailService = snailService;
    }

    @GetMapping
    public ApiResponse<List<Snail>> getAllSnail() {
        // Get the current authenticated user's username
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        // Fetch the list of snails using the instance variable
        List<Snail> snails = snailService.findAllSnails();

        // Create the response with data first and username second
        ApiResponse<List<Snail>> response = new ApiResponse<>(snails, username);

        return response; // Return the ApiResponse object
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
