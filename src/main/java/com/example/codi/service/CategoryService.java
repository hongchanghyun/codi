package com.example.codi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;

import jakarta.persistence.EntityNotFoundException;

import com.example.codi.dto.*;
import com.example.codi.dto.query.CategoryPriceInterface;
import com.example.codi.dto.query.NamePriceInterface;
import com.example.codi.repository.ItemRepository;

@Service
public class CategoryService {

    private final ItemRepository itemRepository;
    private final RedisTemplate<String, Object> redisTemplate;

    public CategoryService(ItemRepository itemRepository, RedisTemplate<String, Object> redisTemplate) {
        this.itemRepository = itemRepository;
        this.redisTemplate = redisTemplate;
    }

    @Cacheable(value = "categoryLowestPrices", unless = "#result == null")
    public CategoryLowestPriceResponse getCategoryLowestPrices() {
        List<CategoryPriceInterface> results = itemRepository.findLowestPricesByCategory();

        if (results.isEmpty()) {
            throw new EntityNotFoundException("No categories or items found");
        }

        List<CategoryLowestPriceResponse.CategoryPrice> categoryPrices = results.stream()
            .map(result -> new CategoryLowestPriceResponse.CategoryPrice(
                result.getCategory(),  // category
                result.getBrand(),  // brand
                result.getPrice()  // price
            ))
            .collect(Collectors.toList());

        long totalPrice = categoryPrices.stream()
            .mapToLong(CategoryLowestPriceResponse.CategoryPrice::getPrice)
            .sum();

        return new CategoryLowestPriceResponse(categoryPrices, totalPrice);
    }

    @Cacheable(value = "categoryPriceRange", key = "#category", unless = "#result == null")
    public CategoryPriceRangeResponse getCategoryPriceRange(String category) {
        NamePriceInterface lowestPrice = itemRepository.findLowestPriceByCategory(category);
        if (lowestPrice == null) {
            throw new EntityNotFoundException("No categories or items found");
        }

        NamePriceInterface highestPrice = itemRepository.findHighestPriceByCategory(category);

        if (highestPrice == null) {
            throw new EntityNotFoundException("No categories or items found");
        }

        return new CategoryPriceRangeResponse(
            category,
            new CategoryPriceRangeResponse.BrandPrice(lowestPrice.getName(), lowestPrice.getPrice()),
            new CategoryPriceRangeResponse.BrandPrice(highestPrice.getName(), highestPrice.getPrice())
        );
    }
}