package com.example.cookbook.recipesCategory.recipies;

import com.example.cookbook.recipesCategory.RecipeCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findByRecipeCategory(RecipeCategory recipeCategory);
}
