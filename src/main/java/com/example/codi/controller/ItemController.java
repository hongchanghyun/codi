package com.example.codi.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.codi.dto.ItemDto;
import com.example.codi.dto.SuccessResponse;
import com.example.codi.service.ItemService;

import lombok.Value;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<ItemResponse> addItem(@RequestBody ItemDto itemDto) {
        Long id = itemService.addItem(itemDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ItemResponse(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuccessResponse> updateItem(@PathVariable Long id, @RequestBody ItemDto itemDto) {
        boolean success = itemService.updateItem(id, itemDto);
        return ResponseEntity.ok(new SuccessResponse(success));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse> deleteItem(@PathVariable Long id) {
        boolean success = itemService.deleteItem(id);
        return ResponseEntity.ok(new SuccessResponse(success));
    }

    @Value
    private static class ItemResponse {
        Long id;
    }
}
