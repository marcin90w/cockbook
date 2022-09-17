package com.example.cookbook.recipe;

import org.springframework.stereotype.Service;

@Service
public class RecipeDtoMapper {
    RecipeDto map(Recipe recipe) {
        RecipeDto dto = new RecipeDto();
        dto.setId(recipe.getId());
        dto.setRecipeImgUrl(recipe.getRecipeImgUrl());
        dto.setDescription(dto.getDescription());
        dto.setLikedRecipe(recipe.getLikedRecipe());
        dto.setIngredients(recipe.getIngredients());
        dto.setInstruction(recipe.getInstruction());
        dto.setName(recipe.getName());
        dto.setPrepareTime(recipe.getPrepareTime());
        return dto;
    }
}
