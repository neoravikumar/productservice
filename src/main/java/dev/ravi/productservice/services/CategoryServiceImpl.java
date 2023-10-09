package dev.ravi.productservice.services;

import dev.ravi.productservice.dtos.CategoryDto;
import dev.ravi.productservice.dtos.GenericProductDto;
import dev.ravi.productservice.models.Category;
import dev.ravi.productservice.models.Product;
import dev.ravi.productservice.repositories.CategoryRepository;
import dev.ravi.productservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository,
                               ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Category getCategory(String uuid) {
        Optional<Category> categoryOptional = categoryRepository.findById(UUID.fromString(uuid));

        if (categoryOptional.isEmpty()) {
            return null;
        }

        Category category = categoryOptional.get();

        //List<Product> products = category.getProduct();


        return category;
    }

    public List<String> getProductTitles(List<String> categoryUUIDs) {
        List<UUID> uuids = new ArrayList<>();

        /*for (String uuid: categoryUUIDs) {
            uuids.add(UUID.fromString(uuid));
        }
//
//        List<Category> categories = categoryRepository.findAllById(uuids);
//
//
//        List<String> titles = new ArrayList<>();
//
//        categories.forEach(
//                category -> {
//                    category.getProducts().forEach(
//                            product -> {
//                                titles.add(product.getTitle());
//                            }
//                    );
//                }
//        );
//
//
//        return titles;

        List<Category> categories = categoryRepository.findAllById(uuids);

        List<Product> products = productRepository.findAllByCategoryIn(categories);
*/
        List<String> titles = new ArrayList<>();

        /*for (Product p: products) {
            titles.add(p.getTitle());
        }*/

        return titles;
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public List<CategoryDto> getAllCategoies() {
        List<Category>  categories = categoryRepository.findAll();
        return getCategoryDtos(categories);

    }

    @Override
    public List<CategoryDto> getAllCategoiesByName(String TitleName) {
        List<Category> categories = categoryRepository.findAllByTitle(TitleName);
        return getCategoryDtos(categories);
    }

    private static List<CategoryDto> getCategoryDtos(List<Category> categories) {
        List<CategoryDto> results = new ArrayList<>();
        if (Objects.nonNull(categories) && categories.size() > 0) {
            categories.stream().forEach(databean -> {
                CategoryDto gpdto = new CategoryDto();
                        gpdto.setTitle(databean.getTitle());
                        gpdto.setDescription(databean.getDescription());
                        gpdto.setPrice(databean.getPrice());
                        results.add(gpdto);
                    }
            );
        }
        return results;
    }


}
