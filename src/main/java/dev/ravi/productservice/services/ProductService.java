package dev.ravi.productservice.services;

import dev.ravi.productservice.dtos.GenericProductDto;
import dev.ravi.productservice.exceptions.NotFoundException;

import java.util.List;

public interface ProductService {

    GenericProductDto createProduct(GenericProductDto product);

    GenericProductDto getProductById(Long id) throws NotFoundException;

    GenericProductDto getProductById(String uuid) throws NotFoundException;

    List<GenericProductDto> getAllProducts();

    GenericProductDto deleteProductById(String id);

    GenericProductDto updateProduct(GenericProductDto product);
}
