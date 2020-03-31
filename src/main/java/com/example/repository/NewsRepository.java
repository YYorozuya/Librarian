package com.example.repository;

import com.example.entity.News;
import java.util.List;

public interface NewsRepository {
    int insert(News news);
    int delete(int id);
    List<News> findAll();
}
