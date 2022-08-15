package com.example.cookbook.data;

import com.example.cookbook.Repository.RecipeCategory;

import javax.persistence.*;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private RecipeCategory recipeCategory;

    public Recipe() {
    }

    public Recipe(String name, RecipeCategory recipeCategory) {
        this.name = name;
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
}
