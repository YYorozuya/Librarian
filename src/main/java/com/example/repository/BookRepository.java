package com.example.repository;

import com.example.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookRepository {
    int insert(Book book);
    int edit(Book book);
    int editByIsbn(@Param("isbn")String isbn, @Param("name")String name, @Param("author")String author,
                   @Param("category")String category, @Param("price")double price, @Param("floor")int floor,
                   @Param("shelf")int shelf, @Param("area")int area);
    int delete(String id);
    List<Book> findAll();
    List<Book> findByIsbn(String isbn);
    Book findById(String id);
    String maxId(String isbn);

}
