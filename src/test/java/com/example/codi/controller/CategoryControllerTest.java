package com.example.codi.controller;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("embedded-test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql("/test-data.sql")
public class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetCategoryLowestPrices() throws Exception {
        mockMvc.perform(get("/api/categories/lowest-prices"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.categoryPrices").isArray())
            .andExpect(jsonPath("$.categoryPrices.length()").value(8))
            .andExpect(jsonPath("$.categoryPrices[0].category").exists())
            .andExpect(jsonPath("$.categoryPrices[0].brand").exists())
            .andExpect(jsonPath("$.categoryPrices[0].price").exists())
            .andExpect(jsonPath("$.totalPrice").exists());
    }

    @Test
    public void testGetCategoryPriceRange() throws Exception {
        String categoryName = "상의";

        mockMvc.perform(get("/api/categories/price-range").param("category", categoryName))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.category").value(categoryName))
            .andExpect(jsonPath("$.lowestPrice.brand").value("C"))
            .andExpect(jsonPath("$.lowestPrice.price").value(10000))
            .andExpect(jsonPath("$.highestPrice.brand").value("I"))
            .andExpect(jsonPath("$.highestPrice.price").value(11400));
    }
}
