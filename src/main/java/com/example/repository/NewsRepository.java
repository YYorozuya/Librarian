package com.example.repository;

import com.example.domain.News;
import java.util.List;

public interface NewsRepository {
    int insert(News news);
    int delete(int id);
    int edit(News news);
    List<News> findAll();
}
