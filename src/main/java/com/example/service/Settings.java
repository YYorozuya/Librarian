package com.example.service;

import com.example.repository.SettingRepository;
import com.example.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class Settings {
    public static int addCategory(String category) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        SettingRepository sr = sqlSession.getMapper(SettingRepository.class);
        int result = sr.addCategory(category);
        sqlSession.commit();
        return result;
    }

    public static int delCategory(String category) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        SettingRepository sr = sqlSession.getMapper(SettingRepository.class);
        int result = sr.delCategory(category);
        sqlSession.commit();
        return result;
    }

    public static List<String> getCategories() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        SettingRepository sr = sqlSession.getMapper(SettingRepository.class);
        List<String> list = sr.findAllC();
        sqlSession.commit();
        return list;
    }

    public static int addLocation(String category) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        SettingRepository sr = sqlSession.getMapper(SettingRepository.class);
        int result = sr.addLocation(category);
        sqlSession.commit();
        return result;
    }

    public static int delLocation(String category) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        SettingRepository sr = sqlSession.getMapper(SettingRepository.class);
        int result = sr.delLocation(category);
        sqlSession.commit();
        return result;
    }

    public static List<String> getLocations() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        SettingRepository sr = sqlSession.getMapper(SettingRepository.class);
        List<String> list = sr.findAllL();
        sqlSession.commit();
        return list;
    }

}
