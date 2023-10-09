package dev.ravi.productservice.controllers;

import dev.ravi.productservice.dtos.CategoryDto;
import dev.ravi.productservice.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/gellAll")
    public List<CategoryDto> getAllCategories() {
        return categoryService.getAllCategoies();
    }

    @GetMapping("/gellCategoryByTitle/{categoryTitle}")
    public List<CategoryDto> getAllCategoriesByTitle(@PathVariable String categoryTitle) {
        return categoryService.getAllCategoiesByName(categoryTitle);
    }

}
