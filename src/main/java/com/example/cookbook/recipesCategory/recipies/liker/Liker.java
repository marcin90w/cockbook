package com.example.cookbook.recipesCategory.recipies.liker;

import com.example.cookbook.recipesCategory.recipies.Recipe;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Liker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateOfPressLike;

    private boolean isLiked;

    @ManyToOne
    private Recipe recipe;

    public Liker() {
    }

    public Liker(Recipe recipe) {
        this.recipe = recipe;
        dateOfPressLike = LocalDate.now();
        isLiked = true;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }
}
