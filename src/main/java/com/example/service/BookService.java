package com.example.service;

import com.example.entity.Book;
import com.example.repository.BookRepository;
import com.example.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import java.text.DecimalFormat;
import java.util.List;

public class BookService {
    public static int add(String isbn, String name, String author, String category, double price, int floor, int shelf, int area, int amount) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BookRepository br = sqlSession.getMapper(BookRepository.class);
        String maxId = br.maxId(isbn);
        Integer before; //获取添加之前该isbn书籍的最大编号
        if(maxId == null)
            before = 0;
        else
            before = Integer.parseInt(maxId.substring(maxId.length()-4));

        int current = before; //正在添加书籍的编号,每添加一个副本就递增
        DecimalFormat df = new DecimalFormat("0000");
        for (int i = 0; i < amount; i++) {
            String id = isbn + df.format(++current);
            Book book = new Book(id,name,author,category,price,floor,shelf,area,0);
            br.insert(book);
        }
        String maxId2 = br.maxId(isbn);
        Integer after = Integer.parseInt(maxId2.substring(maxId2.length()-4));//获取添加之后该isbn书籍的最大编号
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return after-before; //返回实际添加的书籍数目
    }

    public static int delele(String id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BookRepository br = sqlSession.getMapper(BookRepository.class);
        int result = br.delete(id);
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return result;
    }

    public static Book findById(String id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BookRepository br = sqlSession.getMapper(BookRepository.class);
        Book find = br.findById(id);
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return find;
    }

    public static List<Book> findByIsbn(String isbn) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BookRepository br = sqlSession.getMapper(BookRepository.class);
        List<Book> list = br.findByIsbn(isbn);
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return list;
    }

    public static List<Book> bookList() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BookRepository br = sqlSession.getMapper(BookRepository.class);
        List<Book> list = br.findAll();
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return list;
    }

    public static int edit(String id, String name, String author, String category, double price, int floor, int shelf, int area) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BookRepository br = sqlSession.getMapper(BookRepository.class);
        int result = br.edit(new Book(id,name,author,category,price,floor,shelf,area,0));
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return result;
    }

    public static int editByIsbn(String isbn, String name, String author, String category, double price, int floor, int shelf, int area) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BookRepository br = sqlSession.getMapper(BookRepository.class);
        int result = br.editByIsbn(isbn,name,author,category,price,floor,shelf,area);
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return result;
    }


}
