package dev.ravi.productservice.services;

import dev.ravi.productservice.dtos.GenericProductDto;
import dev.ravi.productservice.exceptions.NotFoundException;
import dev.ravi.productservice.models.Product;
import dev.ravi.productservice.repositories.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;


@Primary
@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto productDto) {
        Product productEntity = new Product();
        BeanUtils.copyProperties(productDto, productEntity);
        productRepository.save(productEntity);
        return productDto;
    }

    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundException {
        return null;
    }

    @Override
    public GenericProductDto getProductById(String uuid) throws NotFoundException {
        Optional<Product> result = productRepository.findById(UUID.fromString(uuid));
        if(result.isPresent()){
            Product product = result.get();
            GenericProductDto gpdto = new GenericProductDto();
            gpdto.setTitle(product.getTitle());
            gpdto.setDescription(product.getDescription());
            gpdto.setPrice(product.getPrice());
            return gpdto;
        }
        throw new NotFoundException("product Not found");
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        List<Product> dataResult = productRepository.findAll();
        List<GenericProductDto> results = new ArrayList<>();
        if (Objects.nonNull(dataResult) && dataResult.size() > 0) {
            for (Product databean : dataResult){
                GenericProductDto gpdto = new GenericProductDto();
                gpdto.setTitle(databean.getTitle());
                gpdto.setDescription(databean.getDescription());
                gpdto.setPrice(databean.getPrice());
                results.add(gpdto);
            }
        }
        return results;
    }

    @Override
    public GenericProductDto deleteProductById(String uuid) {
        productRepository.deleteById(UUID.fromString(uuid));
        return new GenericProductDto();
    }

    @Override
    public GenericProductDto updateProduct(GenericProductDto productDto) {
        Optional<Product> myProduct = productRepository.findById(UUID.fromString(productDto.getUuid()));
        if(myProduct.isPresent()){
            BeanUtils.copyProperties(productDto, myProduct);
            myProduct.get().setTitle(productDto.getTitle());
            myProduct.get().setDescription(productDto.getDescription());
            myProduct.get().setPrice(productDto.getPrice());
            myProduct.get().setImage(productDto.getImage());
            myProduct.get().setCategory(productDto.getCategory());
            productRepository.save(myProduct.get());
        }
        return productDto;
    }


}
