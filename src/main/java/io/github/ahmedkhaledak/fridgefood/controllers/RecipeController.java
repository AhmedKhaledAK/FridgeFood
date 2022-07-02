package io.github.ahmedkhaledak.fridgefood.controllers;

import io.github.ahmedkhaledak.fridgefood.models.Recipe;
import io.github.ahmedkhaledak.fridgefood.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/recipe")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @PostMapping("/add")
    public String addRecipe(@RequestBody  Recipe recipe) {
        try {
            return recipeService.createRecipe(recipe);
        } catch (IOException e) {
            e.printStackTrace();
            return "False";
        }
    }

    @GetMapping("/get/{recipeId}")
    public Recipe getRecipe(@PathVariable String recipeId) {
        try {
            return recipeService.getRecipeById(recipeId);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/getAll/{recipeName}")
     public List<Recipe> getRecipesByName(@PathVariable String recipeName) {
        try {
            return recipeService.getRecipesByName(recipeName);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @GetMapping("/greeting")
    public String greeting() {
        return "hello";
    }
}
