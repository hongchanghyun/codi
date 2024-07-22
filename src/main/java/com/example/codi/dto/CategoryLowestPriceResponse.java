package com.example.codi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CategoryLowestPriceResponse {
    private List<CategoryPrice> categoryPrices;
    private long totalPrice;

    @Getter
    @Setter
    @AllArgsConstructor
    public static class CategoryPrice {
        private String category;
        private String brand;
        private long price;
    }
}
