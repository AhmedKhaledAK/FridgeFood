package io.github.ahmedkhaledak.fridgefood.services;

import io.github.ahmedkhaledak.fridgefood.models.Recipe;

import java.io.IOException;
import java.util.List;

public interface RecipeService {
    String createRecipe(Recipe recipe) throws IOException;
    Recipe getRecipeById(String recipeId) throws IOException;
    List<Recipe> getRecipesByName(String name) throws IOException;
}
