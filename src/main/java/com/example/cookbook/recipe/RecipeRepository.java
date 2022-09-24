package com.example.cookbook.recipe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

//    List<Recipe> findByRecipeCategory(Category category);

//    Optional<Recipe> findFirstByOrderByLikedRecipeDesc();
    Recipe findFirstByOrderByLikedRecipeDesc();
}
