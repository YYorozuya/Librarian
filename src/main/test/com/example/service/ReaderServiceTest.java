package com.example.service;

import com.example.entity.Reader;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

import static org.junit.jupiter.api.Assertions.*;

class ReaderServiceTest {
    @Test
    void test() {
        Reader reader = ReaderService.findById("13125");
        System.out.println(reader);
    }
}