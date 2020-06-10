package com.example.repository;

import com.example.domain.LendingRecord;
import com.example.domain.Reader;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReaderRepository {
    int insert(Reader reader);
    int edit(@Param("id")String id, @Param("name")String name, @Param("passwd")String passwd, @Param("email")String email);
    int delete(String id);
    List<Reader> findAll();
    Reader findById(String id);
    int deposit();
    Double sumBy(@Param("since")long since); //计算一个时间点之后的保证金收入总额

}
