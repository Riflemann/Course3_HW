package ru.recipe.app.recipeapp.services;

import ru.recipe.app.recipeapp.model.Recipe;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface RecipeService {
    void addRecipe(Recipe recipe);

    Recipe obtainRecipe(int number);

    void deleteRecipe(int counter);

    List<Recipe> obtainAllRecipe();

    void editRecipe(int id, Recipe newRecipe);

    Path createRecipeTxt() throws IOException;
}
