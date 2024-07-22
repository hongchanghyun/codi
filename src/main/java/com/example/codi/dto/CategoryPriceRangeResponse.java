package com.example.codi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Getter
@Setter
@AllArgsConstructor
public class CategoryPriceRangeResponse {
    private String category;
    private BrandPrice lowestPrice;
    private BrandPrice highestPrice;

    @Getter
    @Setter
    @AllArgsConstructor
    public static class BrandPrice {
        private String brand;
        private long price;
    }
}
