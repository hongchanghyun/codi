package com.example.codi.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.codi.dto.*;
import com.example.codi.service.BrandService;

import lombok.Value;

@RestController
@RequestMapping("/api/brands")
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/lowest-price")
    public ResponseEntity<BrandLowestPriceResponse> getBrandLowestPrice() {
        return ResponseEntity.ok(brandService.getBrandLowestPrice());
    }

    @PostMapping
    public ResponseEntity<BrandResponse> addBrand(@RequestBody BrandDto brandDto) {
        Long id = brandService.addBrand(brandDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new BrandResponse(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuccessResponse> updateBrand(@PathVariable Long id, @RequestBody BrandDto brandDto) {
        boolean success = brandService.updateBrand(id, brandDto);
        return ResponseEntity.ok(new SuccessResponse(success));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse> deleteBrand(@PathVariable Long id) {
        boolean success = brandService.deleteBrand(id);
        return ResponseEntity.ok(new SuccessResponse(success));
    }

    @Value
    private static class BrandResponse {
        Long id;
    }
}
