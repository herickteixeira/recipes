package com.recipes.application.usecases.get;

import com.recipes.domain.model.Recipe;
import com.recipes.domain.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetRecipeById {

    @Autowired
    private RecipeRepository repository;

    public Recipe execute(String id) {
        var optionalRecipe = repository.findById(id);
        if (optionalRecipe.isEmpty()) throw new RuntimeException(String.format("Task of id %s not found", id));

        return optionalRecipe.get();
    }
}
