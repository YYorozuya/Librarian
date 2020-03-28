package com.example.service;

import com.example.entity.BRrecord;
import com.example.repository.BRrecordRepository;
import com.example.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import java.time.Instant;

public class BRService {
    public static int borrow(String bid, String rid) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BRrecordRepository brr = sqlSession.getMapper(BRrecordRepository.class);
        long now = Instant.now().getEpochSecond(); //获得当前以秒为单位的时间戳
        BRrecord record = new BRrecord(0,bid,rid,now,0);
        int result = brr.borrow(record);
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return result;
    }

    public static int returnb(int id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BRrecordRepository brr = sqlSession.getMapper(BRrecordRepository.class);
        long now = Instant.now().getEpochSecond(); //获得当前以秒为单位的时间戳
        int result = brr.returnb(id,now);
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return result;
    }
}
