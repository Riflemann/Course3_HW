package ru.recipe.app.recipeapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.recipe.app.recipeapp.model.Recipe;
import ru.recipe.app.recipeapp.services.RecipeService;

import java.util.ArrayList;

@RestController
@RequestMapping("/add")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
    Recipe recipe = new Recipe("Глазунья", 10, new ArrayList<>(), new ArrayList<>());

    @GetMapping("/recipe")
    public Recipe addRecipe() {
        recipeService.addRecipe(recipe);
        return recipeService.obtainRecipe(0);
    }

}