package com.example.repository;

import com.example.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

class ReaderRepositoryTest {
    @Test
    void test() {
        int test;
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        ReaderRepository rr = sqlSession.getMapper(ReaderRepository.class);
        test = rr.delete("123");
        System.out.println(test);
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
    }

}