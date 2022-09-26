package com.example.cookbook.recipe;

import com.example.cookbook.category.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String recipeImgUrl;

    private Integer prepareTime;

    private String description;

    private String ingredients;

    private String instruction;

    private int likedRecipe;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @ManyToOne
    @JsonIgnore
    private Category category;

    public Recipe() {
        date = LocalDate.now();
    }

    public Recipe(Long id, String name, String recipeImgUrl, Integer prepareTime, String description, String ingredients, String instruction, LocalDate date, Category category) {
        this.id = id;
        this.name = name;
        this.recipeImgUrl = recipeImgUrl;
        this.prepareTime = prepareTime;
        this.description = description;
        this.ingredients = ingredients;
        this.instruction = instruction;
        this.date = date;
        this.category = category;
    }

    @JsonProperty
    String category() {
        return category.getType();
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getRecipeImgUrl() {
        return recipeImgUrl;
    }

    public void setRecipeImgUrl(String recipeImgUrl) {
        this.recipeImgUrl = recipeImgUrl;
    }

    public Integer getPrepareTime() {
        return prepareTime;
    }

    public void setPrepareTime(Integer prepareTime) {
        this.prepareTime = prepareTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getLikedRecipe() {
        return likedRecipe;
    }

    public void setLikedRecipe(int likedRecipe) {
        this.likedRecipe = likedRecipe;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", recipeUrl='" + recipeImgUrl + '\'' +
                ", prepareTime=" + prepareTime +
                ", recipeCategory=" + category +
                '}';
    }
}
