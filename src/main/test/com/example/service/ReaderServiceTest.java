package com.example.service;

import com.example.entity.Reader;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReaderServiceTest {
    @Test
    void test() {
        ReaderService.register("46445","456666","sfg","asd");
        //ReaderService.edit("465","hhh","666","da");
        //ReaderService.delete("465");
    }
}