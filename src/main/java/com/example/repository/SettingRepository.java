package com.example.repository;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SettingRepository {

    int addCategory(@Param("name")String name);
    int delCategory(@Param("name")String name);
    List<String> findAllC();
    int addLocation(@Param("name")String name);
    int delLocation(@Param("name")String name);
    List<String> findAllL();
}
