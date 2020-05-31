package com.example.repository;

import com.example.domain.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookRepository {
    int insert(Book book);
    int edit(Book book);
    int editByIsbn(@Param("isbn")String isbn, @Param("name")String name, @Param("author")String author,
                   @Param("category")String category, @Param("price")Double price, @Param("location")String location);
    int delete(String id);
    List<Book> findAll();
    List<Book> findByIsbn(String isbn);
    List<Book> findFuzzy(@Param("name")String name, @Param("author")String author, @Param("category")String category);
    List<Book> findNew(@Param("isbn")String isbn, @Param("amount")int amount);
    Book findById(String id);
    String maxId(String isbn);

}
