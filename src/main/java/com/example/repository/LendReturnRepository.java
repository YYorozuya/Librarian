package com.example.repository;

import com.example.entity.LendReturnRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LendReturnRepository {
    int lend(LendReturnRecord record);
    int returN(@Param("id")int id, @Param("time")long time);
    int getBNum(String rid); //获取一个用户所借书籍数量
    String resvdBy(String bkid); //检查一本书是否被预定。返回预定者的id
    Long isLent(String bkid); //检查一本书是否已被借走，返回0表示被借走，否则可以借出
    Long getBTime(int id); //返回一本书的借用时间
    List<LendReturnRecord> findAll();
    LendReturnRecord findById(int id);
}
