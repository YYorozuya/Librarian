package com.example.service;

import com.google.zxing.WriterException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ReaderServiceTest {
    @Test
    void test() throws IOException, WriterException {
        String a = Class.class.getResource("/").getPath().replaceFirst("/", "").replaceAll("test-classes/", "");
        System.out.println(a);
    }

}