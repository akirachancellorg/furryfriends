package com.entjava.furryfriends.controller;

import com.entjava.furryfriends.model.Cat;
import com.entjava.furryfriends.service.CatService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.entjava.furryfriends.model.ApiResponse;

@RestController
@RequestMapping("/cats")
public class CatController {

    private final CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    @GetMapping
    public ApiResponse<List<Cat>> getAllCats() {
        // Get the current authenticated user's username
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        // Fetch the list of cats using the instance variable
        List<Cat> catList = catService.findAllCats();

        // Create the response with data first and username second
        ApiResponse<List<Cat>> response = new ApiResponse<>(catList, username);

        return response; // Return the ApiResponse object
    }

    @PostMapping
    public Cat createCat(@RequestBody Cat cat) {
        return catService.saveCat(cat);
    }

    @DeleteMapping("/{id}")
    public void deleteCat(@PathVariable Long id) {
        catService.deleteCat(id);
    }
}
