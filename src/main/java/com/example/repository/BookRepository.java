package com.example.repository;

import com.example.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookRepository {
    int insert(Book book);
    int edit(Book book);
    int delete(String id);
    List<Book> findAll();
    Book findById(String id);
    String maxId(String isbn);
}
