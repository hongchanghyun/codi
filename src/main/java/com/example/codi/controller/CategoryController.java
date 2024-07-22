package com.example.codi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.codi.dto.CategoryLowestPriceResponse;
import com.example.codi.dto.CategoryPriceRangeResponse;
import com.example.codi.service.CategoryService;


@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/lowest-prices")
    public ResponseEntity<CategoryLowestPriceResponse> getCategoryLowestPrices() {
        return ResponseEntity.ok(categoryService.getCategoryLowestPrices());
    }

    @GetMapping("/price-range")
    public ResponseEntity<CategoryPriceRangeResponse> getCategoryPriceRange(@RequestParam String category) {
        return ResponseEntity.ok(categoryService.getCategoryPriceRange(category));
    }
}
