package com.example.repository;

import com.example.entity.BRrecord;
import com.example.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.*;

class BRrecordRepositoryTest {
    @Test
    void test() {
        int test;
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BRrecordRepository br = sqlSession.getMapper(BRrecordRepository.class);
        test = br.returnb(2,1000000000000000L);
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        System.out.println(test);
    }

}