package com.recipes.web.controller;

import com.recipes.application.usecases.create.CreateRecipeUseCase;
import com.recipes.application.usecases.delete.DeleteRecipeById;
import com.recipes.application.usecases.get.GetAllRecipesUseCase;
import com.recipes.application.usecases.get.GetByRecipeByIngredient;
import com.recipes.application.usecases.get.GetRecipeByCategory;
import com.recipes.application.usecases.get.GetRecipeById;
import com.recipes.domain.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    @Autowired
    private CreateRecipeUseCase createRecipeUseCase;
    @Autowired
    private GetAllRecipesUseCase getCreateRecipeUseCase;
    @Autowired
    private GetRecipeById getRecipeById;
    @Autowired
    private DeleteRecipeById deleteRecipeById;
    @Autowired
    private GetByRecipeByIngredient getByRecipeByIngredient;
    @Autowired
    private GetRecipeByCategory getRecipeByCategory;

    @PostMapping
    public ResponseEntity<Recipe> save(@RequestBody Recipe recipe) {
        createRecipeUseCase.execute(recipe);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        var recipes = getCreateRecipeUseCase.execute();
        return ResponseEntity.ok(recipes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipesById(@PathVariable String id) {
        var recipes = getRecipeById.execute(id);
        return ResponseEntity.ok(recipes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipeById(@PathVariable String id) {
        deleteRecipeById.execute(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/ingredients")
    public ResponseEntity<List<Recipe>> getRecipeByIngredient(@RequestParam String ingredient) {
        var recipes = getByRecipeByIngredient.execute(ingredient);
        return ResponseEntity.ok(recipes);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Recipe>> getRecipeByCategory(@RequestParam String category) {
        var recipes = getRecipeByCategory.execute(category);
        return ResponseEntity.ok(recipes);
    }
}
