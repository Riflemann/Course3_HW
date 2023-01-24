package ru.recipe.app.recipeapp.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.List;
@Data
public class Recipe {

    @NotBlank
    String name;
    @Positive
    int timeCooking;
    List<Ingredients> ingredients;
    List<String> steps;

}
