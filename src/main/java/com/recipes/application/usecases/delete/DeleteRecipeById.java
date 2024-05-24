package com.recipes.application.usecases.delete;

import com.recipes.domain.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteRecipeById {

    @Autowired
    private RecipeRepository repository;

    public void execute(String id) {
        var optionalRecipe = repository.findById(id);
        if (optionalRecipe.isEmpty()) throw new RuntimeException(String.format("Task of id %s not found", id));

        repository.deleteById(id);
    }
}
