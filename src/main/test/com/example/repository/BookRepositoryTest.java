package com.example.repository;

import com.example.entity.Book;
import com.example.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.*;

class BookRepositoryTest {
    @Test
    void repoTest () {
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