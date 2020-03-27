package com.example.service;

import com.example.entity.Book;
import com.example.repository.BookRepository;
import com.example.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.text.DecimalFormat;
import java.util.List;

public class BookService {
   public static int addBook(String isbn, String name, String author, String category, double price, int floor, int shelf, int area, int ammount) {
       SqlSession sqlSession = MyBatisUtil.getSqlSession();
       BookRepository br = sqlSession.getMapper(BookRepository.class);
       String maxId = br.maxId(isbn);
       Integer current; //获取当前isbn书籍的最大ID
       if(maxId == null)
           current = 0;
       else
           current = Integer.parseInt(maxId.substring(maxId.length()-4));

       DecimalFormat df = new DecimalFormat("0000");
       for (int i = 0; i < ammount; i++) {
           String id = isbn + df.format(++current);//正在添加书籍的ID,每添加一个副本就递增
           Book book = new Book(id,name,author,category,price,floor,shelf,area);
           br.insert(book);
       }
       sqlSession.commit();
       MyBatisUtil.closeSqlSession(sqlSession);
       return 0;
    }

    public static int delBook(String id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BookRepository br = sqlSession.getMapper(BookRepository.class);
        int status = br.delete(id);
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return status;
    }

    public static Book findBook(String id) {
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

    public static int editBook(String id, String name, String author, String category, double price, int floor, int shelf, int area) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BookRepository br = sqlSession.getMapper(BookRepository.class);
        int status = br.edit(new Book(id,name,author,category,price,floor,shelf,area));
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return status;
    }



}
