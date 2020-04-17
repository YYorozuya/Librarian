package com.example.repository;

import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;

class BookRepositoryTest {
    @Test
    void test() {
        /*int test;
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BookRepository br = sqlSession.getMapper(BookRepository.class);
        test = br.getCopyNum("00016");
        System.out.println(test);*/
        DecimalFormat df = new DecimalFormat("0000");
        String id = "isbn" + df.format(5);
        System.out.println(id);
    }

}