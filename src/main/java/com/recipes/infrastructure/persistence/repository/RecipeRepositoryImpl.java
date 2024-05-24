package com.recipes.infrastructure.persistence.repository;

import com.recipes.domain.model.Recipe;
import com.recipes.domain.repository.RecipeRepository;
import com.recipes.infrastructure.persistence.document.RecipeDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class RecipeRepositoryImpl implements RecipeRepository {

    @Autowired
    private RecipeRepositoryMongo recipeRepositoryMongo;

    @Override
    public Optional<Recipe> findById(String id) {
        var optionalRecipe = recipeRepositoryMongo.findById(id);
        if (optionalRecipe.isEmpty()) Optional.empty();
        return Optional.of(toDomain(optionalRecipe.get()));
    }

    @Override
    public List<Recipe> findAll() {
        return recipeRepositoryMongo.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Recipe> findByIngredientsContaining(String ingredient) {
        return recipeRepositoryMongo.findByIngredientsContaining(ingredient);
    }

    @Override
    public List<Recipe> findByCategory(String category) {
        return recipeRepositoryMongo.findByCategory(category);
    }

    @Override
    public void save(Recipe recipe) {
        recipeRepositoryMongo.save(toDocument(recipe));
    }

    @Override
    public void deleteById(String id) {
        recipeRepositoryMongo.deleteById(id);
    }

    private Recipe toDomain(RecipeDocument document) {
        return new Recipe(
                document.getId(),
                document.getName(),
                document.getDescription(),
                document.getIngredients(),
                document.getInstructions(),
                document.getCategory(),
                document.getReviews());
    }

    private RecipeDocument toDocument(Recipe recipe) {
        RecipeDocument document = new RecipeDocument();
        document.setId(recipe.getId());
        document.setName(recipe.getName());
        document.setDescription(recipe.getDescription());
        document.setIngredients(recipe.getIngredients());
        document.setInstructions(recipe.getInstructions());
        document.setCategory(recipe.getCategory());
        document.setReviews(recipe.getReviews());
        return document;
    }
}
