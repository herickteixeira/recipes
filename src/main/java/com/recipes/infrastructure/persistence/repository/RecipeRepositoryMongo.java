package com.recipes.infrastructure.persistence.repository;

import com.recipes.domain.model.Recipe;
import com.recipes.infrastructure.persistence.document.RecipeDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RecipeRepositoryMongo extends MongoRepository <RecipeDocument, String>{

    List<Recipe> findByIngredientsContaining(String ingredient);
    List<Recipe> findByCategory(String category);
}
