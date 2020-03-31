package com.example.repository;

import com.example.entity.Reader;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReaderRepository {
    int insert(Reader reader);
    int edit(Reader reader);
    int delete(String id);
    List<Reader> findAll();
    Reader findById(String id);
    Double sumBy(@Param("since")long since); //计算一个时间点之后的保证金收入总额
}
