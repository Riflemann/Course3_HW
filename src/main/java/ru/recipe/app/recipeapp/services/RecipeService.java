package ru.recipe.app.recipeapp.services;

import ru.recipe.app.recipeapp.model.Recipe;

public interface RecipeService {
    void addRecipe(Recipe recipe);

    Recipe obtainRecipe(int number);
}
