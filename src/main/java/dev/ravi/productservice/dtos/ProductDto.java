package dev.ravi.productservice.dtos;

import dev.ravi.productservice.models.Category;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private String title;
    private Double price;
    private String description;
    private String image;
    private Category category;
}
