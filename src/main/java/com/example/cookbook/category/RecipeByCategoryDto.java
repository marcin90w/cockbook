package com.example.cookbook.category;

public class RecipeByCategoryDto {
    private Long id;
    private String name;
    private String recipeImgUrl;
    private Integer prepareTime;
    private int likedRecipe;

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

    public int getLikedRecipe() {
        return likedRecipe;
    }

    public void setLikedRecipe(int likedRecipe) {
        this.likedRecipe = likedRecipe;
    }
}
