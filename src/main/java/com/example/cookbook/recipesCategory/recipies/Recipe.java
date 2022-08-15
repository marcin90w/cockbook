package com.example.cookbook.recipesCategory.recipies;

import com.example.cookbook.recipesCategory.RecipeCategory;

import javax.persistence.*;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String recipeUrl;

    @ManyToOne
    private RecipeCategory recipeCategory;

    public Recipe() {
    }

    public Recipe(String name, String recipeUrl, RecipeCategory recipeCategory) {
        this.name = name;
        this.recipeUrl = recipeUrl;
        this.recipeCategory = recipeCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RecipeCategory getRecipeCategory() {
        return recipeCategory;
    }

    public void setRecipeCategory(RecipeCategory recipeCategory) {
        this.recipeCategory = recipeCategory;
    }

    public String getRecipeUrl() {
        return recipeUrl;
    }

    public void setRecipeUrl(String recipeUrl) {
        this.recipeUrl = recipeUrl;
    }
}
