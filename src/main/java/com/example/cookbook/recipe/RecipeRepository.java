package com.example.cookbook.recipe;

import com.example.cookbook.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findByRecipeCategory(Category recipeCategory);

//    Optional<Recipe> findFirstByOrderByLikedRecipeDesc();
    Recipe findFirstByOrderByLikedRecipeDesc();

}
