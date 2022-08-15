package com.example.cookbook.recipesCategory.recipies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeDescriptionRepository extends JpaRepository<RecipeDescription, Long> {
}
