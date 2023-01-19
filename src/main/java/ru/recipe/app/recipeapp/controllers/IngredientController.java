package ru.recipe.app.recipeapp.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.recipe.app.recipeapp.model.Ingredients;
import ru.recipe.app.recipeapp.services.IngredientService;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping("/add")
    public ResponseEntity<Ingredients> addIngredient(@RequestBody Ingredients ingredient) {
        ingredientService.addIngredient(ingredient);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<Ingredients> editIngredient (@PathVariable int id, @RequestBody Ingredients ingredient) {
        ingredientService.editIngredient(id, ingredient);
        return ResponseEntity.ok().body(ingredient);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Ingredients> deleteIngredient(@PathVariable int id) {
        ingredientService.deleteIngredient(id);
        return ResponseEntity.ok().build();
    }
}
