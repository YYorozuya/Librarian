package com.example.repository;

import com.example.domain.FineRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FineRepository {
    int insert(@Param("id")int id);
    int pay(@Param("id")int id, @Param("time")long time, @Param("amount")double amount);
    Double sumBy(@Param("since")long since); //计算一个时间点之后的总罚金收入
    int check(String id);
    List<FineRecord> findAll();
    List<FineRecord> findByReader(String rid);
}
