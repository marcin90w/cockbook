package com.example.cookbook.category;

import com.example.cookbook.recipe.Recipe;
import org.springframework.stereotype.Service;

@Service
public class RecipeByCategoryMapperDto {
    RecipeByCategoryDto map(Recipe recipe) {
        RecipeByCategoryDto dto = new RecipeByCategoryDto();
        dto.setId(recipe.getId());
        dto.setName(recipe.getName());
        dto.setLikedRecipe(recipe.getLikedRecipe());
        dto.setRecipeImgUrl(recipe.getRecipeImgUrl());
        dto.setPrepareTime(recipe.getPrepareTime());
        return dto;
    }
}
