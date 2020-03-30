package com.example.repository;

import com.example.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FineRepositoryTest {

    @Test
    void test() {
        int test;
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        FineRepository rr = sqlSession.getMapper(FineRepository.class);
        test = rr.insert(1,3);
        System.out.println(test);
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
    }

}