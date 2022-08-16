package com.example.cookbook.recipesCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RecipeCategoryRepository extends JpaRepository<RecipeCategory, Long> {

}
