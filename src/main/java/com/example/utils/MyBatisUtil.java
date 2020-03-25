package com.example.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;

public final class MyBatisUtil {
    //不被继承
    private MyBatisUtil() {}
    private static SqlSessionFactory sqlSessionFactory;

    static {
        final String resource = "mybatis-config.xml";
        try {
            InputStream in = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("加载config失败！");
        }
    }


    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }

    public static void closeSqlSession(SqlSession session) {
        if (session != null)
            session.close();
    }



}
