package com.example.codi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CategoryLowestPriceResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<CategoryPrice> categoryPrices;
    private long totalPrice;

    @Getter
    @Setter
    @AllArgsConstructor
    public static class CategoryPrice implements Serializable {
        private static final long serialVersionUID = 1L;

        private String category;
        private String brand;
        private long price;
    }
}
