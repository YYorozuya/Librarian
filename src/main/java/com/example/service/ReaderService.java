package com.example.service;

import com.example.entity.Reader;
import com.example.repository.ReaderRepository;
import com.example.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ReaderService {
    public static int register(String id, String passwd, String name) {
        Reader reader = new Reader(id,passwd,name);
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

    public static int edit(String id, String passwd, String name) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        ReaderRepository rr = sqlSession.getMapper(ReaderRepository.class);
        int result = rr.edit(new Reader(id,passwd,name));
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
