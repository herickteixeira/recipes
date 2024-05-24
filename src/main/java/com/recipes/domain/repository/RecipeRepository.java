package com.recipes.domain.repository;

import com.recipes.domain.model.Recipe;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository {
    Optional<Recipe> findById(String id);

    List<Recipe> findAll();

    List<Recipe> findByIngredientsContaining(String ingredient);

    List<Recipe> findByCategory(String category);

    void save(Recipe task);

    void deleteById(String id);
}
