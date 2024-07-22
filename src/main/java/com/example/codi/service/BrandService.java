package com.example.codi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.codi.dto.BrandDto;
import com.example.codi.dto.BrandLowestPriceResponse;
import com.example.codi.dto.query.NamePriceInterface;
import com.example.codi.entity.Brand;
import com.example.codi.repository.BrandRepository;
import com.example.codi.repository.ItemRepository;

@Service
public class BrandService {

    private final ItemRepository itemRepository;
    private final BrandRepository brandRepository;
    private final RedisTemplate<String, Object> redisTemplate;

    public BrandService(ItemRepository itemRepository, BrandRepository brandRepository, RedisTemplate<String, Object> redisTemplate) {
        this.itemRepository = itemRepository;
        this.brandRepository = brandRepository;
        this.redisTemplate = redisTemplate;
    }

    @Cacheable(value = "brandLowestPrice", unless = "#result == null")
    public BrandLowestPriceResponse getBrandLowestPrice() {
        String lowestPriceBrand = itemRepository.findBrandWithLowestTotalPrice();
        List<NamePriceInterface> categoryPrices = itemRepository.findPricesByBrand(lowestPriceBrand);

        List<BrandLowestPriceResponse.CategoryPrice> categories = categoryPrices.stream()
            .map(result -> new BrandLowestPriceResponse.CategoryPrice(
                result.getName(),
                result.getPrice()
            ))
            .collect(Collectors.toList());

        long totalPrice = categories.stream()
            .mapToLong(BrandLowestPriceResponse.CategoryPrice::getPrice)
            .sum();

        return new BrandLowestPriceResponse(lowestPriceBrand, categories, totalPrice);
    }

    @Transactional
    @CacheEvict(cacheNames = {"categoryLowestPrices", "brandLowestPrice", "categoryPriceRange"}, allEntries = true)
    public Long addBrand(BrandDto brandDto) {
        Brand brand = new Brand(brandDto.getName());
        return brandRepository.save(brand).getId();
    }

    @Transactional
    @CacheEvict(cacheNames = {"categoryLowestPrices", "brandLowestPrice", "categoryPriceRange"}, allEntries = true)
    public boolean updateBrand(Long id, BrandDto brandDto) {
        return brandRepository.findById(id).map(brand -> {
            brand.setName(brandDto.getName());
            brandRepository.save(brand);
            return true;
        }).orElse(false);
    }

    @Transactional
    @CacheEvict(cacheNames = {"categoryLowestPrices", "brandLowestPrice", "categoryPriceRange"}, allEntries = true)
    public boolean deleteBrand(Long id) {
        return brandRepository.findById(id).map(brand -> {
            brandRepository.delete(brand);
            return true;
        }).orElse(false);
    }
}
