package com.example.cookbook.recipesCategory;

import com.example.cookbook.recipesCategory.recipies.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeCategoryRepository extends JpaRepository<RecipeCategory, Long> {

}
