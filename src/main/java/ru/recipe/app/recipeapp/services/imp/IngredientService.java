package ru.recipe.app.recipeapp.services.imp;

import org.springframework.stereotype.Service;
import ru.recipe.app.recipeapp.model.Ingredients;

import java.util.HashMap;
import java.util.Map;
@Service
public class IngredientService implements ru.recipe.app.recipeapp.services.IngredientService {
    Map<Integer, Ingredients> ingredientMap = new HashMap<>();

    static int counter = 0;

    @Override
    public void addIngredient(Ingredients ingredient) {
        ingredientMap.put(counter++, ingredient);
    }
    @Override
    public void obtainIngredient(int number) {
        ingredientMap.get(number);
    }
}
