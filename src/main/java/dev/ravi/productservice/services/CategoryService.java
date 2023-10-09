package dev.ravi.productservice.services;

import dev.ravi.productservice.dtos.CategoryDto;
import dev.ravi.productservice.models.Category;

import java.util.List;

public interface CategoryService {
    Category getCategory(String uuid);
    List<String> getProductTitles(List<String> categoryUUIDs);
    List<Category> getAllCategory();

    List<CategoryDto> getAllCategoies();

    List<CategoryDto> getAllCategoiesByName(String categoryName);
}
