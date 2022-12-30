package ru.recipe.app.recipeapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    @GetMapping
    public String helloWorld() {
        return "Приложение запущено";
    }

    @GetMapping("/info")
    public String info() {
        return "Константин" +
                "Проект: Книга рецептов " +
                "Дата создания 30/12/2022" +
                "Книга рецептов в которой собраны все рецепты мира";
    }
}
