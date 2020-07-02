package com.example.service;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ReaderServiceTest {
    @Test
    void test() {
        ReaderService.register("13512345678","Ray","ray@qq.com");
        ReaderService.register("15312345678","James","james@163.com");
        ReaderService.register("18887654321","Jason","jason@gmail.com");
        ReaderService.register("13967891234","Nate","nate@outlook.com");
    }

}