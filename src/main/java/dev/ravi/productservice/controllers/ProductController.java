package dev.ravi.productservice.controllers;

import dev.ravi.productservice.dtos.GenericProductDto;
import dev.ravi.productservice.dtos.ProductDto;
import dev.ravi.productservice.exceptions.NotFoundException;
import dev.ravi.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {


    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/getall")
    public List<GenericProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    // localhost:8080/products/{id}
    // localhost:8080/products/123
    @GetMapping("/getsingle/{uuid}")
    public GenericProductDto getASingleProduct(@PathVariable("uuid") String uuid) throws NotFoundException {
     return productService.getProductById(uuid);
    }

    @PostMapping("/addProduct")
    public GenericProductDto createProduct(@RequestBody GenericProductDto product) {
        GenericProductDto result = productService.createProduct(product);
        return result;
    }

    @DeleteMapping("/deleteById/{uuid}")
    public void deleteProductById(@PathVariable String uuid) {
        productService.deleteProductById(uuid);
    }


    @PutMapping("/updateProduct")
    public void updateAProduct(@RequestBody GenericProductDto product) {
        GenericProductDto result = productService.updateProduct(product);
    }
}
