package com.example.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BRServiceTest {
    @Test
    void test() {
        int test;
        //test = BRService.borrow("465","456");
        test = BRService.returnb(3);
        System.out.println(test);
    }

}