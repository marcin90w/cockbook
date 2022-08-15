package com.example.cookbook;

import com.example.cookbook.recipesCategory.RecipeCategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private RecipeCategoryRepository recipeCategoryRepository;

    public HomeController(RecipeCategoryRepository recipeCategoryRepository) {
        this.recipeCategoryRepository = recipeCategoryRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("recipeCategories", recipeCategoryRepository.findAll());
        return "home";
    }
}