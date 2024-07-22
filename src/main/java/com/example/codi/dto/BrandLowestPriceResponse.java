package com.example.codi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class BrandLowestPriceResponse {
    private String brand;
    private List<CategoryPrice> categories;
    private long totalPrice;

    @Getter
    @Setter
    @AllArgsConstructor
    public static class CategoryPrice {
        private String category;
        private long price;
    }
}
