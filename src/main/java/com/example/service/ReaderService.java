package com.example.service;

import com.example.domain.LendingRecord;
import com.example.domain.Reader;
import com.example.repository.FineRepository;
import com.example.repository.LendingRepository;
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


    /**
     * @param id  待删除用户的id
     * @return 1：删除成功  -1：用户有书未还或罚款未缴纳  0：用户不存在或者系统错误
     */
    public static int delete(String id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        ReaderRepository rr = sqlSession.getMapper(ReaderRepository.class);
        FineRepository fr = sqlSession.getMapper(FineRepository.class);
        int thingsToDo = fr.check(id);
        int result;
        if (thingsToDo > 0)
            result = -1;
        else {
            result = rr.delete(id);
            sqlSession.commit();
            MyBatisUtil.closeSqlSession(sqlSession);
        }
        return result;
    }

    public static int edit(String id, String passwd, String name, String email) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        ReaderRepository rr = sqlSession.getMapper(ReaderRepository.class);
        int result;
        if(rr.findById(id)==null) //如果该读者不存在返回-1
            result = -1;
        else
            result = rr.edit(id, passwd, name, email);
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

    public static List<LendingRecord> lendingList() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        LendingRepository brr = sqlSession.getMapper(LendingRepository.class);
        List<LendingRecord> list = brr.findAll();
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return list;
    }

}
