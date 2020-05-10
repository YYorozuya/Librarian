package com.example.repository;

import com.example.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

class LendingRecordRepositoryTest {
    @Test
    void test() {
        long test;
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        LendingRepository br = sqlSession.getMapper(LendingRepository.class);
        test = br.getBNum("123");
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        System.out.println(test);
    }

}