package ru.recipe.app.recipeapp.services;

import java.io.File;

public interface FileService {

    boolean saveToFile(String json, String fileName);

    String readFile(String fileName);

    boolean cleanRecipeFile(String fileName);

    File getFile(String fileName);
}
