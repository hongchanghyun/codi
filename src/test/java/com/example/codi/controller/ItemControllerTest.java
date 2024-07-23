package com.example.codi.controller;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.example.codi.dto.ItemDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("embedded-test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql("/test-data.sql")
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testAddItem() throws Exception {
        ItemDto itemDto = new ItemDto("New Brand", "New Category", "New Item", 10000L);

        mockMvc.perform(post("/api/items")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(itemDto)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.id").exists());
    }

    @Test
    public void testUpdateItem() throws Exception {
        ItemDto itemDto = new ItemDto("New Brand", "New Category", "New Item", 10000L);

        // POST 요청으로 아이템 추가
        MvcResult result = mockMvc.perform(post("/api/items")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(itemDto)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.id").exists())
            .andReturn();

        // 응답 본문에서 ID 추출
        String responseString = result.getResponse().getContentAsString();
        Long id = JsonPath.parse(responseString).read("$.id", Long.class);

        // 추출한 ID를 사용하여 아이템 업데이트 테스트
        ItemDto updatedItemDto = new ItemDto("Updated Brand", "Updated Category", "Updated Item", 20000L);

        mockMvc.perform(put("/api/items/" + id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedItemDto)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.success").value(true));
    }

    @Test
    public void testDeleteItem() throws Exception {
        ItemDto itemDto = new ItemDto("New Brand", "New Category", "New Item", 10000L);

        // POST 요청으로 아이템 추가
        MvcResult result = mockMvc.perform(post("/api/items")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(itemDto)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.id").exists())
            .andReturn();

        // 응답 본문에서 ID 추출
        String responseString = result.getResponse().getContentAsString();
        Long id = JsonPath.parse(responseString).read("$.id", Long.class);

        // 추출한 ID를 사용하여 아이템 삭제 테스트
        mockMvc.perform(delete("/api/items/" + id))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.success").value(true));
    }
}