package com.example.service;

import com.example.entity.Book;
import com.example.entity.Reader;
import com.example.repository.BookRepository;
import com.example.repository.ReaderRepository;
import com.example.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

public class ReaderService {
    public static int register(String id, String passwd, String name) {
        Reader reader = new Reader(id,passwd,name);
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        ReaderRepository rr = sqlSession.getMapper(ReaderRepository.class);
        int status = rr.insert(reader);
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return status;
    }
}
