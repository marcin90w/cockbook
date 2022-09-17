package com.example.cookbook.recipe;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecipeService {
    private RecipeRepository recipeRepository;
    private RecipeDtoMapper recipeDtoMapper;

    public RecipeService(RecipeRepository recipeRepository, RecipeDtoMapper recipeDtoMapper) {
        this.recipeRepository = recipeRepository;
        this.recipeDtoMapper = recipeDtoMapper;
    }

    Optional<RecipeDto> getRecipeById(Long id) {
        return recipeRepository.findById(id)
                .map(recipeDtoMapper::map);
    }
}
