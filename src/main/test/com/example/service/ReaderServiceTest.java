package com.example.service;

import com.google.zxing.WriterException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ReaderServiceTest {
    @Test
    void test() throws IOException, WriterException {
        ReaderService.register("12345678901","da","132@a.com");
        ReaderService.register("23456789011","wq","1sad@a.com");
        ReaderService.register("34567890112","wf","13xz2@a.com");
        ReaderService.register("45678901123","sd","1da2@a.com");
    }

}