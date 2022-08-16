package com.example.cookbook.recipesCategory.recipies.liker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikerRepository extends JpaRepository<Liker, Long> {
}
