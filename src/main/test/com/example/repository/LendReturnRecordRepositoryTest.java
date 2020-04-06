package com.example.repository;

import com.example.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

class LendReturnRecordRepositoryTest {
    @Test
    void test() {
        long test;
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        LendReturnRepository br = sqlSession.getMapper(LendReturnRepository.class);
        test = br.getBNum("123");
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        System.out.println(test);
    }

}