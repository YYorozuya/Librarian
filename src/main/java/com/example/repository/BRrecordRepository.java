package com.example.repository;

import com.example.entity.BRrecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BRrecordRepository {
    int borrow(BRrecord record);
    int returnb(@Param("id")int id, @Param("time")long time);
    List<BRrecord> findAll();
}
