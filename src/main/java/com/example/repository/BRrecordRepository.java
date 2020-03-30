package com.example.repository;

import com.example.entity.BRrecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BRrecordRepository {
    int borrow(BRrecord record);
    int returnb(@Param("id")int id, @Param("time")long time);
    int getBNum(String rid); //获取一个用户所借书籍数量
    Long check(String bkid); //检查一本书是否已被借走，返回null或者0表示被借走
    Long getBTime(int id); //返回一本书的借用时间
    List<BRrecord> findAll();
    BRrecord findById(int id);
}
