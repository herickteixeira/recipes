package com.recipes.infrastructure.persistence.document;

import com.recipes.domain.model.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecipeDocument {

    @Id
    private String id;
    private String name;
    private String description;
    private List<String> ingredients;
    private String instructions;
    private String category;
    private List<Review> reviews;
}
