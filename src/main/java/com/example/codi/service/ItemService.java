package com.example.codi.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.codi.dto.ItemDto;
import com.example.codi.entity.Brand;
import com.example.codi.entity.Category;
import com.example.codi.entity.Item;
import com.example.codi.repository.BrandRepository;
import com.example.codi.repository.CategoryRepository;
import com.example.codi.repository.ItemRepository;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;

    public ItemService(ItemRepository itemRepository, BrandRepository brandRepository, CategoryRepository categoryRepository) {
        this.itemRepository = itemRepository;
        this.brandRepository = brandRepository;
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    @CacheEvict(cacheNames = {"categoryLowestPrices", "brandLowestPrice", "categoryPriceRange"}, allEntries = true)
    public Long addItem(ItemDto itemDto) {
        Brand brand = brandRepository.findByName(itemDto.getBrand())
            .orElseGet(() -> brandRepository.save(new Brand(itemDto.getBrand())));
        Category category = categoryRepository.findByName(itemDto.getCategory())
            .orElseGet(() -> categoryRepository.save(new Category(itemDto.getCategory())));

        Item item = new Item(itemDto.getName(), category, brand, itemDto.getPrice());
        return itemRepository.save(item).getId();
    }

    @Transactional
    @CacheEvict(cacheNames = {"categoryLowestPrices", "brandLowestPrice", "categoryPriceRange"}, allEntries = true)
    public boolean updateItem(Long id, ItemDto itemDto) {
        return itemRepository.findById(id).map(item -> {
            Brand brand = brandRepository.findByName(itemDto.getBrand())
                .orElseGet(() -> brandRepository.save(new Brand(itemDto.getBrand())));
            Category category = categoryRepository.findByName(itemDto.getCategory())
                .orElseGet(() -> categoryRepository.save(new Category(itemDto.getCategory())));

            item.setName(itemDto.getName());
            item.setBrand(brand);
            item.setCategory(category);
            item.setPrice(itemDto.getPrice());
            itemRepository.save(item);
            return true;
        }).orElse(false);
    }

    @Transactional
    @CacheEvict(cacheNames = {"categoryLowestPrices", "brandLowestPrice", "categoryPriceRange"}, allEntries = true)
    public boolean deleteItem(Long id) {
        return itemRepository.findById(id).map(item -> {
            itemRepository.delete(item);
            return true;
        }).orElse(false);
    }
}
