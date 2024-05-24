package com.recipes.application.usecases.create;

import com.recipes.domain.model.Recipe;
import com.recipes.domain.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateRecipeUseCase {

    @Autowired
    private RecipeRepository repository;

    public void execute(Recipe request) {
        var recipe = Recipe.create(request.getName(), request.getDescription(), request.getIngredients(), request.getInstructions(), request.getCategory(), request.getReviews());
        repository.save(recipe);
    }
}
