package ru.recipe.app.recipeapp.services.imp;

import org.springframework.stereotype.Service;
import ru.recipe.app.recipeapp.model.Recipe;
import ru.recipe.app.recipeapp.services.RecipeService;

import java.util.HashMap;
import java.util.Map;
@Service
public class RecipeServiceImpl implements RecipeService {

    Map<Integer, Recipe> recipeMap = new HashMap<>();

    static int counter = 0;
    @Override
    public void addRecipe(Recipe recipe) {
        recipeMap.put(counter++, recipe);
    }
    @Override
    public Recipe obtainRecipe(int number) {
        return recipeMap.get(number);
    }
}
