package com.example.cookbook.Repository;

import com.example.cookbook.data.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findByRecipeCategory(RecipeCategory recipeCategory);
}
