package com.example.codi.controller;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.example.codi.dto.BrandDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Sql("/test-data.sql")
@Transactional
public class BrandControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetBrandLowestPrice() throws Exception {
        mockMvc.perform(get("/api/brands/lowest-price"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.brand").value("D"))
            .andExpect(jsonPath("$.categories").isArray())
            .andExpect(jsonPath("$.categories.length()").value(8))
            .andExpect(jsonPath("$.categories[0].category").value("상의"))
            .andExpect(jsonPath("$.categories[0].price").value(10100))
            .andExpect(jsonPath("$.totalPrice").value(36100));
    }

    @Test
    public void testAddBrand() throws Exception {
        BrandDto brandDto = new BrandDto();
        brandDto.setName("New Brand");

        mockMvc.perform(post("/api/brands")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(brandDto)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.id").exists());
    }

    @Test
    @Order(3)
    public void testUpdateBrand() throws Exception {
        BrandDto brandDto = new BrandDto();
        brandDto.setName("Updated Brand");

        mockMvc.perform(put("/api/brands/10")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(brandDto)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.success").value(true));
    }

    @Test
    public void testDeleteBrand() throws Exception {
        mockMvc.perform(delete("/api/brands/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.success").value(true));
    }
}