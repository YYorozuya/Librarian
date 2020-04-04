package com.example.service;

import com.example.entity.Reader;
import com.example.repository.ReaderRepository;
import com.example.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.time.Instant;
import java.util.List;

public class ReaderService {
    public static int register(String id, String name, String email) {
        long now = Instant.now().getEpochSecond(); //获得当前以秒为单位的时间戳
        Reader reader = new Reader(id,"12345678",name,email,now,300);
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        ReaderRepository rr = sqlSession.getMapper(ReaderRepository.class);
        int result = rr.insert(reader);
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return result;
    }

    public static int delete(String id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        ReaderRepository rr = sqlSession.getMapper(ReaderRepository.class);
        int result = rr.delete(id);
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return result;
    }

    public static int edit(String id, String passwd, String name, String email) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        ReaderRepository rr = sqlSession.getMapper(ReaderRepository.class);
        int result = rr.edit(new Reader(id,passwd,name,email,0L,300));
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return result;
    }

    public static List<Reader> findAll() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        ReaderRepository rr = sqlSession.getMapper(ReaderRepository.class);
        List<Reader> list = rr.findAll();
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return list;
    }

    public static Reader findById(String id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        ReaderRepository rr = sqlSession.getMapper(ReaderRepository.class);
        Reader reader = rr.findById(id);
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return reader;
    }

}
