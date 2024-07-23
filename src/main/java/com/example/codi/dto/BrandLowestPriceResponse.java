package com.example.codi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class BrandLowestPriceResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private String brand;
    private List<CategoryPrice> categories;
    private long totalPrice;

    @Getter
    @Setter
    @AllArgsConstructor
    public static class CategoryPrice implements Serializable {
        private static final long serialVersionUID = 1L;

        private String category;
        private long price;
    }
}
