package com.example.repository;

import com.example.entity.BRrecord;
import com.example.entity.FineRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FineRepository {
    int insert(FineRecord record);
    int pay(@Param("id")int id, @Param("time")long time);
    List<FineRecord> findAll();
}
