package com.recipes.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    private String id;
    private String name;
    private String description;
    private List<String> ingredients;
    private String instructions;
    private String category;
    private List<Review> reviews;

    public Recipe(String name, String description, List<String> ingredients, String instructions, String category, List<Review> reviews) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.category = category;
        this.reviews = reviews;
    }

    public static Recipe create(String name, String description, List<String> ingredients, String instructions, String category, List<Review> reviews){
        return new Recipe(name, description, ingredients, instructions, category, reviews);
    }
}
