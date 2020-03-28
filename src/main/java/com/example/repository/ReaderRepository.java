package com.example.repository;

import com.example.entity.Reader;

import java.util.List;

public interface ReaderRepository {
    int insert(Reader reader);
    int edit(Reader reader);
    int delete(String id);
    List<Reader> findAll();
    Reader findById(String id);
}
