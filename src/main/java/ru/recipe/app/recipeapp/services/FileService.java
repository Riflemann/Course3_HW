package ru.recipe.app.recipeapp.services;

public interface FileService {

    boolean saveToFile(String json, String fileName);

    String readFile(String fileName);
}
