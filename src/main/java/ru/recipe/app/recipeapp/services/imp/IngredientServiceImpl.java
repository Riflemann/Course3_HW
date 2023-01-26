package ru.recipe.app.recipeapp.services.imp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.recipe.app.recipeapp.model.Ingredients;
import ru.recipe.app.recipeapp.services.FileService;
import ru.recipe.app.recipeapp.services.IngredientService;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
@Service
public class IngredientServiceImpl implements IngredientService {

    Map<Integer, Ingredients> ingredientMap = new HashMap<>();

    static int counter = 0;

    @Value("${name.of.file.two}")
    private String ingredientFileName;

    final private FileService fileService;

    public IngredientServiceImpl(FileService fileService) {
        this.fileService = fileService;
    }

    @Override
    public void addIngredient(Ingredients ingredient) {
        ingredientMap.put(counter++, ingredient);
        saveIngredientFile();
    }

    @Override
    public void obtainIngredient(int number) {
        ingredientMap.get(number);
    }

    @Override
    public void editIngredient(int id, Ingredients ingredient) {
        ingredientMap.put(id, ingredient);
        saveIngredientFile();
    }

    @Override
    public void deleteIngredient(int id) {
        ingredientMap.remove(id);
    }

    private void saveIngredientFile() {
        try {
            String json = new ObjectMapper().writeValueAsString(ingredientMap);
            fileService.saveToFile(json, ingredientFileName);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private void readFromFile() {
        String json = fileService.readFile(ingredientFileName);
        try {
            ingredientMap = new ObjectMapper().readValue(json, new TypeReference<HashMap<Integer, Ingredients>>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @PostConstruct
    private void init() {
        readFromFile();
    }
}
