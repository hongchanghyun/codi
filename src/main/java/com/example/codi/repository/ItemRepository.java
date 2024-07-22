package com.example.codi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.codi.dto.query.CategoryPriceInterface;
import com.example.codi.dto.query.NamePriceInterface;
import com.example.codi.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

    //가격이 중복될 경우 브랜드명 오름차순으로 1개 노출 (JPQL처리가 안되어 네이티브쿼리)
    @Query(value =
        "SELECT category_id, category, brand, price FROM (" +
            "   SELECT " +
            "       c.id as category_id, " +
            "       c.name as category, " +
            "       b.name as brand, " +
            "       i.item_price as price, " +
            "       ROW_NUMBER() OVER (PARTITION BY c.id ORDER BY i.item_price, b.name) as rn " +
            "   FROM item i " +
            "   JOIN category c ON i.category_id = c.id " +
            "   JOIN brand b ON i.brand_id = b.id " +
            "   WHERE (c.id, i.item_price) IN (" +
            "       SELECT category_id, MIN(item_price) " +
            "       FROM item " +
            "       GROUP BY category_id" +
            "   )" +
            ") ranked " +
            "WHERE rn = 1 " +
            "ORDER BY category_id",
        nativeQuery = true)
    List<CategoryPriceInterface> findLowestPricesByCategory();

    @Query("SELECT i.brand.name FROM Item i GROUP BY i.brand.name ORDER BY SUM(i.price) ASC LIMIT 1")
    String findBrandWithLowestTotalPrice();

    @Query("SELECT i.category.name as name, i.price as price FROM Item i WHERE i.brand.name = :brandName")
    List<NamePriceInterface> findPricesByBrand(@Param("brandName") String brandName);

    @Query("SELECT i.brand.name as name, i.price as price FROM Item i WHERE i.category.name = :category ORDER BY i.price ASC LIMIT 1")
    NamePriceInterface findLowestPriceByCategory(@Param("category") String category);

    @Query("SELECT i.brand.name as name, i.price as price FROM Item i WHERE i.category.name = :category ORDER BY i.price DESC LIMIT 1")
    NamePriceInterface findHighestPriceByCategory(@Param("category") String category);
}
