package com.example.cookbook.Repository;

import com.example.cookbook.data.RecipeDescription;
import org.springframework.data.repository.CrudRepository;

public interface RecipeDescriptionRepository extends CrudRepository<RecipeDescription, Long> {
}
