package com.example.service;

import com.example.entity.Book;
import com.example.repository.BookRepository;
import com.example.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BookService {
    public static int addBook(String name, String author, String category, double price, int floor, int shelf, int area, int num) {
        Book book = new Book(0L,name,author,category, price, floor,shelf, area, num);
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BookRepository br = sqlSession.getMapper(BookRepository.class);
        int status = br.insert(book);
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return status;
    }

    public static int delBook(long id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BookRepository br = sqlSession.getMapper(BookRepository.class);
        int status = br.delete(id);
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return status;
    }

    public static Book findBook(long id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BookRepository br = sqlSession.getMapper(BookRepository.class);
        Book find = br.findById(id);
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return find;
    }


    public static List<Book> findAll() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BookRepository br = sqlSession.getMapper(BookRepository.class);
        List<Book> list = br.findAll();
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return list;
    }

    public static int editBook(long id, String name, String author, String category, double price, int floor, int shelf, int area, int num) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BookRepository br = sqlSession.getMapper(BookRepository.class);
        int status = br.edit(new Book(id,name,author,category,price,floor,shelf,area,num));
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return status;
    }



}
