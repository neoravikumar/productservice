package dev.ravi.productservice.dtos;

import dev.ravi.productservice.models.Category;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class GenericProductDto {
    private Long id;
    private String uuid;
    private String title;
    private String description;
    private String image;
    private Category category;
    private Double price;
}
