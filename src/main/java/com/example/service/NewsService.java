package com.example.service;

import com.example.domain.News;
import com.example.domain.Reader;
import com.example.repository.NewsRepository;
import com.example.repository.ReaderRepository;
import com.example.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.time.Instant;
import java.util.List;

public class NewsService {

    //发送公告
    public static int postNews(String title, String content) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        NewsRepository nr = sqlSession.getMapper(NewsRepository.class);
        long now = Instant.now().getEpochSecond(); //获得当前以秒为单位的时间戳
        News news = new News(0,title,content,now);
        int result = nr.insert(news);
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return result;
    }

    //公告列表
    public static List<News> newsList() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        NewsRepository nr = sqlSession.getMapper(NewsRepository.class);
        List<News> list = nr.findAll();
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return list;
    }

    public static News findById(int id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        NewsRepository nr = sqlSession.getMapper(NewsRepository.class);
        News result = nr.findById(id);
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return result;
    }


    //删除公告
    public static int deleteNews(int id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        NewsRepository nr = sqlSession.getMapper(NewsRepository.class);
        int result = nr.delete(id);
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return result;
    }

    //编辑公告
    public static int editNews(int id, String title, String content) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        NewsRepository nr = sqlSession.getMapper(NewsRepository.class);
        News news = new News(id,title,content,0);
        int result = nr.edit(news);
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return result;
    }

}
