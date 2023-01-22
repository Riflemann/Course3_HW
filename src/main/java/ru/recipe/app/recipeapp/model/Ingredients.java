package ru.recipe.app.recipeapp.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@Data
public class Ingredients {

    @NotBlank
    private String name;
    @PositiveOrZero
    private int count;
    @NotBlank
    private String measure;

}
