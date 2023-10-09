package dev.ravi.productservice.dtos;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryDto {
    private String title;
    private Double price;
    private String description;
    private String image;
    private List<ProductDto> products;
}
