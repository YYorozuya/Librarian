package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private String id;
    private String name;
    private String author;
    private String category;
    private double price;
    private int floor;
    private int shelf;
    private int area;
    private int reserved;
}
