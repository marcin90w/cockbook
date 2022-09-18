package com.example.cookbook.recipe;

import com.example.cookbook.category.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class RecipeController {

    CategoryService categoryService;
    RecipeService recipeService;



    public RecipeController(RecipeService recipeService, CategoryService categoryService) {
        this.recipeService = recipeService;
        this.categoryService = categoryService;
    }

    @GetMapping("/recipe/like/{id}")
    public String likeRecipe(@PathVariable Long id) {
        if (id > recipeService.recipesListSize()) {
            recipeService.addLike(id);
            return "redirect:/categories/recipes/{id}";
        } else {
            return "error";
        }
    }

    @GetMapping("/recipe/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        recipeService.deleteRecipe(id);
        model.addAttribute("info", "Usunięto przepis o id: " + id + ".");
        return "recipeAddOrEditSuccess";
    }

    @GetMapping("/categories/recipes/{id}")
    String getRecipe(@PathVariable Long id, Model model) {
        model.addAttribute("categories", categoryService.getCategoryList());
        RecipeDto recipeDto = recipeService.getRecipeById(id);
        if (recipeDto != null) {
            model.addAttribute("recipeDto", recipeDto);
            return "recipes";
        } else {
            return "error";
        }
    }

    @GetMapping("/recipe/edit")
    public String edit(@RequestParam Long id, Model model) {
        RecipeDto recipeDto = recipeService.getRecipeById(id);
        if (recipeDto == null) {
            return "error";
        } else {
            model.addAttribute("editRecipe", recipeDto);
            model.addAttribute("categories", categoryService.getCategoryList());
            return "recipeForm";
        }
    }


    @GetMapping("/recipe/add")
    public String add(Model model) {
        RecipeDto recipeDto = new RecipeDto();
        model.addAttribute("editRecipe", recipeDto);
        model.addAttribute("categories", categoryService.getCategoryList());
        return "recipeForm";
    }



    @PostMapping("/recipe/edit")
    public String edit(RecipeDto recipeDto, Model model) {
        String attribute = recipeService.setDataInRecipe(recipeDto);
        model.addAttribute("info", attribute);
        return "recipeAddOrEditSuccess";
    }




}
