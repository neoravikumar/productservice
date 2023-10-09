package dev.ravi.productservice.thirdpartyclients.productsservice.fakestore;

import dev.ravi.productservice.models.Category;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private double price;
    private Category category;
    private String description;
    private String image;
}

// Break till 10:35