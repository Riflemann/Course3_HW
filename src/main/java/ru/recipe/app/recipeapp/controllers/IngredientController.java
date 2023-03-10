package ru.recipe.app.recipeapp.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.recipe.app.recipeapp.model.Ingredients;
import ru.recipe.app.recipeapp.services.IngredientService;

import javax.validation.Valid;

@RestController
@RequestMapping("/ingredients")
@Tag(name = "Констроллер ингредиентов", description = "CRUD-опреции для работы с ингредиентами")
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @Operation(
            summary = "Добавление ингредиента в список",
            description = "Необходимо передать с помощью JSON объект ингредиента"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Ингредиент добавлен"
            )
    })
    @PostMapping("/add")
    public ResponseEntity<Ingredients> addIngredient(@Valid @RequestBody Ingredients ingredient) {
        ingredientService.addIngredient(ingredient);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}")
    public ResponseEntity<Ingredients> editIngredient(@PathVariable int id, @Valid @RequestBody Ingredients ingredient) {
        ingredientService.editIngredient(id, ingredient);
        return ResponseEntity.ok().body(ingredient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Ingredients> deleteIngredient(@PathVariable int id) {
        ingredientService.deleteIngredient(id);
        return ResponseEntity.ok().build();
    }
}
