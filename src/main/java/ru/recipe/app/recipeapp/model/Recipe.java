package ru.recipe.app.recipeapp.model;

import lombok.Data;

import java.util.List;
@Data
public class Recipe {
    String name;
    int timeCooking;
    List<Ingredients> ingredients;
    List<String> steps;

    public Recipe(String name, int timeCooking, List<Ingredients> ingredients, List<String> steps) {
        setName(name);
        setTimeCooking(timeCooking);
        this.ingredients = ingredients;
        this.steps = steps;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isBlank()) {
            this.name = name;
        } else {
            this.name = "Default";
        }
    }

    public int getTimeCooking() {
        return timeCooking;
    }

    public void setTimeCooking(int timeCooking) {
        if (timeCooking >= 0) {
            this.timeCooking = timeCooking;
        } else {
            this.timeCooking = -1;
        }
    }

    public List<Ingredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getSteps() {
        return steps;
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }
}
