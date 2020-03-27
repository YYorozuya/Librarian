package com.example.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {

    @Test
    void servTest() {
        BookService.addBook("7788945","张旭","AD","AD",36.55,1,2,3,30);
        //BookService.delBook("77889450001");
    }
}