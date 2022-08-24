package com.example.cookbook.recipesCategory;

import com.example.cookbook.recipesCategory.recipes.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RecipeCategoryRepository extends JpaRepository<RecipeCategory, Long> {

//    Optional<RecipeCategory> findFirstByOrderByTitleDesc();
}
