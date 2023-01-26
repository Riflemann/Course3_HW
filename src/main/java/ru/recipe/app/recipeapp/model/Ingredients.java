package ru.recipe.app.recipeapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@Data
@NoArgsConstructor
public class Ingredients {

    @NotBlank
    private String name;
    @PositiveOrZero
    private int count;
    @NotBlank
    private String measure;

}
