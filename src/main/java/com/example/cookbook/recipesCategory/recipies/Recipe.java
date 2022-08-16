package com.example.cookbook.recipesCategory.recipies;

import com.example.cookbook.recipesCategory.RecipeCategory;

import javax.persistence.*;
import java.util.List;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String recipeUrl;

    private Integer prepareTime;

    @ManyToOne
    private RecipeCategory recipeCategory;

    @OneToMany(mappedBy = "recipe")
    private List<RecipeDescription> recipeDescriptionList;

    public Recipe() {
    }

    public Recipe(String name, String recipeUrl, Integer prepareTime, RecipeCategory recipeCategory) {
        this.name = name;
        this.recipeUrl = recipeUrl;
        this.prepareTime = prepareTime;
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

    public Integer getPrepareTime() {
        return prepareTime;
    }

    public void setPrepareTime(Integer prepareTime) {
        this.prepareTime = prepareTime;
    }

    public List<RecipeDescription> getRecipeDescriptionList() {
        return recipeDescriptionList;
    }

    public void setRecipeDescriptionList(List<RecipeDescription> recipeDescriptionList) {
        this.recipeDescriptionList = recipeDescriptionList;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", recipeUrl='" + recipeUrl + '\'' +
                ", prepareTime=" + prepareTime +
                ", recipeCategory=" + recipeCategory +
                '}';
    }
}
