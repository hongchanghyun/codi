package com.example.codi.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.codi.entity.*;
import com.example.codi.repository.*;

@Configuration
public class DataInitializer {

    @Bean
    @Profile("!test")  // 테스트 프로파일이 아닐 때만 실행
    public CommandLineRunner initData(ItemRepository itemRepository,
        BrandRepository brandRepository,
        CategoryRepository categoryRepository) {
        return args -> {
            // 카테고리 생성
            Category tops = categoryRepository.save(new Category("상의"));
            Category outer = categoryRepository.save(new Category("아우터"));
            Category pants = categoryRepository.save(new Category("바지"));
            Category sneakers = categoryRepository.save(new Category("스니커즈"));
            Category bag = categoryRepository.save(new Category("가방"));
            Category hat = categoryRepository.save(new Category("모자"));
            Category socks = categoryRepository.save(new Category("양말"));
            Category accessory = categoryRepository.save(new Category("액세서리"));

            // 브랜드 생성
            Brand[] brands = new Brand[9];
            for (char c = 'A'; c <= 'I'; c++) {
                brands[c - 'A'] = brandRepository.save(new Brand(String.valueOf(c)));
            }

            // 상품 데이터 생성
            long[][] prices = {
                {11200, 5500, 4200, 9000, 2000, 1700, 1800, 2300},
                {10500, 5900, 3800, 9100, 2100, 2000, 2000, 2200},
                {10000, 6200, 3300, 9200, 2200, 1900, 2200, 2100},
                {10100, 5100, 3000, 9500, 2500, 1500, 2400, 2000},
                {10700, 5000, 3800, 9900, 2300, 1800, 2100, 2100},
                {11200, 7200, 4000, 9300, 2100, 1600, 2300, 1900},
                {10500, 5800, 3900, 9000, 2200, 1700, 2100, 2000},
                {10800, 6300, 3100, 9700, 2100, 1600, 2000, 2000},
                {11400, 6700, 3200, 9500, 2400, 1700, 1700, 2400}
            };

            Category[] categories = {tops, outer, pants, sneakers, bag, hat, socks, accessory};

            for (int i = 0; i < brands.length; i++) {
                for (int j = 0; j < categories.length; j++) {
                    itemRepository.save(new Item("Item " + (char)('A' + i) + (j + 1), categories[j], brands[i], prices[i][j]));
                }
            }
        };
    }
}
