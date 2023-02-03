package ru.recipe.app.recipeapp.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.recipe.app.recipeapp.model.Recipe;
import ru.recipe.app.recipeapp.services.RecipeService;

import javax.validation.Valid;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

@RestController
@RequestMapping("/recipe")
@Tag(name = "Констроллер рецептов", description = "CRUD-опреции для работы с рецептами")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @Operation(
            summary = "Добавление рецепта в мапу",
            description = "Необходимо передать с помощью JSON объект рецепта"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Рецепт добавлен"
            )
    })
    @PostMapping("/add")
    public ResponseEntity<Recipe> addRecipe(@Valid @RequestBody Recipe recipe) {
        recipeService.addRecipe(recipe);
        return ResponseEntity.ok(recipe);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Recipe> editRecipe(@PathVariable int id, @Valid @RequestBody Recipe recipe) {
        recipeService.editRecipe(id, recipe);
        return ResponseEntity.ok().body(recipe);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Recipe> deleteRecipe(@PathVariable int id) {
        recipeService.deleteRecipe(id);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/gettxtfile")
    public ResponseEntity<Object> getTxtFile() {
        try {
            Path path = recipeService.createRecipeTxt();
            if (Files.size(path) == 0) {
                return ResponseEntity.noContent().build();
            }
            InputStreamResource resource = new InputStreamResource(new FileInputStream(path.toFile()));
            return ResponseEntity.ok()
                    .contentType(MediaType.TEXT_PLAIN)
                    .contentLength(Files.size(path))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"recipeBook.txt\"")
                    .body(resource);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(e.toString());
        }

    }


}
