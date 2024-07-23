package com.example.codi.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Getter
@Setter
@AllArgsConstructor
public class CategoryPriceRangeResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private String category;
    private BrandPrice lowestPrice;
    private BrandPrice highestPrice;

    @Getter
    @Setter
    @AllArgsConstructor
    public static class BrandPrice implements Serializable {
        private static final long serialVersionUID = 1L;

        private String brand;
        private long price;
    }
}
