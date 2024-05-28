package com.recipes.application.usecases.get;

import com.recipes.domain.model.Recipe;
import com.recipes.domain.repository.RecipeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class GetByRecipeByIngredient {

    private static final Logger log = LoggerFactory.getLogger(GetByRecipeByIngredient.class);
    @Autowired
    private RecipeRepository repository;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private static final String INGREDIENT_CACHE_PREFIX = "recipes::ingredient::";

    public List<Recipe> execute(String ingredient) {
        String cacheKey = INGREDIENT_CACHE_PREFIX + ingredient;

        List<Recipe> recipes = (List<Recipe>) redisTemplate.opsForValue().get(cacheKey);

        if (recipes == null) {
            log.info("Without cache");
            recipes = repository.findByIngredientsContaining(ingredient);

            log.info("Adding cache");
            redisTemplate.opsForValue().set(cacheKey, recipes);

            redisTemplate.expire(cacheKey, 6, TimeUnit.HOURS);
        }

        log.info("Cached");
        return recipes;
    }
}
