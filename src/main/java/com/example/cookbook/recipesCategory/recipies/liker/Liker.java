package com.example.cookbook.recipesCategory.recipies.liker;

import com.example.cookbook.recipesCategory.recipies.Recipe;

import javax.persistence.*;

@Entity
public class Liker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int likedRecipe;

    @ManyToOne
    private Recipe recipe;

    public Liker() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getLikedRecipe() {
        return likedRecipe;
    }

    public void setLikedRecipe(int likedRecipe) {
        this.likedRecipe = likedRecipe;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
