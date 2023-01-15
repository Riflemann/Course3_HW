package ru.recipe.app.recipeapp.services;

import ru.recipe.app.recipeapp.model.Ingredients;
import ru.recipe.app.recipeapp.model.Recipe;

import java.util.Map;

public interface IngredientService {

    void addIngredient(Ingredients ingredient);

    void obtainIngredient(int number);
}
