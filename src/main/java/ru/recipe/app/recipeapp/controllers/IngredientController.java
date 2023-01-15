package ru.recipe.app.recipeapp.controllers;

import org.springframework.web.bind.annotation.*;
import ru.recipe.app.recipeapp.model.Ingredients;
import ru.recipe.app.recipeapp.services.imp.IngredientService;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping("/ingredient")
    public void add(@RequestBody Ingredients ingredient) {
        ingredientService.addIngredient(ingredient);
        ingredientService.obtainIngredient(0);
    }

}
