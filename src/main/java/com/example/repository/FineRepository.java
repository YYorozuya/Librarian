package com.example.repository;

import com.example.entity.BRrecord;
import com.example.entity.FineRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FineRepository {
    int insert(@Param("id")int id, @Param("amount")double amount);
    int pay(@Param("id")int id, @Param("time")long time, @Param("amount")double amount);
    List<FineRecord> findAll();
}
