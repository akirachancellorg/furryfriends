package com.entjava.furryfriends.controller;

import com.entjava.furryfriends.model.Cat;
import com.entjava.furryfriends.service.CatService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cats")
public class CatController {

    private final CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    @GetMapping
    public List<Cat> getAllCats() {
        return catService.findAllCats();
    }

    @PostMapping
    public Cat createCat(@RequestBody Cat cat) {
        return catService.saveCat(cat);
    }

    @DeleteMapping("/{id}")
    public void deleteCat(@PathVariable Long id) {
        catService.deleteCat(id);
    }

    @PutMapping("/{id}")
    public Cat updateCat(@PathVariable Long id, @RequestBody Cat updatedCat) {
        Cat existingCat = catService.findAllCats().stream().
                filter(cat -> cat.getId().equals(id)).
                findFirst().
                orElse(null);

        if (existingCat != null) {
            existingCat.setName(updatedCat.getName());
            existingCat.setAge(updatedCat.getAge());
            existingCat.setColor(updatedCat.getColor());
            existingCat.setIndoor(updatedCat.isIndoor());
            return catService.saveCat(existingCat);
        }

        return null;
    }
}

