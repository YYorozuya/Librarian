package com.example.service;

import com.example.domain.Book;
import com.example.domain.DelRecord;
import com.example.repository.BookRepository;
import com.example.repository.DelRecordRepository;
import com.example.repository.LendingRepository;
import com.example.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.text.DecimalFormat;
import java.time.Instant;
import java.util.List;

public class BookService {
    public static int add(String isbn, String name, String author, String category, double price, String location, int amount) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BookRepository br = sqlSession.getMapper(BookRepository.class);
        String maxId = br.maxId(isbn);
        int before; //获取添加之前该isbn书籍的最大编号
        if(maxId == null)
            before = 0;
        else
            before = Integer.parseInt(maxId.substring(maxId.length()-4));

        int current = before; //正在添加书籍的编号,每添加一个副本就递增
        DecimalFormat df = new DecimalFormat("0000");
        for (int i = 0; i < amount; i++) {
            String id = isbn + df.format(++current);
            Book book = new Book(id,name,author,category,price,location);
            br.insert(book);
        }
        String maxId2 = br.maxId(isbn);
        int after = Integer.parseInt(maxId2.substring(maxId2.length()-4));//获取添加之后该isbn书籍的最大编号
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return after-before; //返回实际添加的书籍数目
    }

    public static int delete(String bkid, String libid, String reason) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BookRepository br = sqlSession.getMapper(BookRepository.class);
        LendingRepository lrr = sqlSession.getMapper(LendingRepository.class);
        int result;
        Long lent = lrr.isLent(bkid); //检查该书是否已被借走
        if (lent == null || lent != 0) { //未被借走
            result = br.delete(bkid);
            DelRecordRepository dr = sqlSession.getMapper(DelRecordRepository.class);
            long now = Instant.now().getEpochSecond();
            dr.insert(new DelRecord(0, bkid, libid, reason, now));
        }
        else
            result = 0;
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

    public static List<Book> findFuzzy(String name, String author, String category) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BookRepository br = sqlSession.getMapper(BookRepository.class);
        List<Book> list = br.findFuzzy(name, author, category);
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

    public static int edit(String id, String name, String author, String category, Double price, String location) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BookRepository br = sqlSession.getMapper(BookRepository.class);
        int result = br.edit(new Book(id,name,author,category,price,location));
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return result;
    }

    public static int editByIsbn(String isbn, String name, String author, String category, Double price, String location) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BookRepository br = sqlSession.getMapper(BookRepository.class);
        int result = br.editByIsbn(isbn,name,author,category,price,location);
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return result;
    }

    public static List<Book> addedList(String isbn, int amount) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BookRepository br = sqlSession.getMapper(BookRepository.class);
        List<Book> list = br.findNew(isbn,amount);
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return list;
    }

}
