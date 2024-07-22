package com.example.codi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Getter
@Setter
@AllArgsConstructor
public class ItemDto {
    private String brand;
    private String category;
    private String name;
    private Long price;
}