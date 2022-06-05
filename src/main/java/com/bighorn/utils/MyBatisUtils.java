package com.bighorn.utils;

/**
 * @author: lzh
 * @date: 2022/5/3 22:44
 * @description:
 */

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * MyBatis工具类
 */
public class MyBatisUtils {
    //创建全局唯一的SqlSessionFactory对象
    private static SqlSessionFactory sqlSessionFactory = null;

    static {
        try {
            //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        }
    }

    /**
     * 获取SqlSession对象
     * @return SqlSession
     */
    public static SqlSession openSession() {
        return sqlSessionFactory.openSession();
    }

    /**
     * 关闭SqlSession,释放资源
     * @param sqlSession
     */
    public static void closeSession(SqlSession sqlSession) {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    /**
     * 提交事务
     * @param sqlSession
     */
    public static void commitSession(SqlSession sqlSession){
        if (sqlSession != null) {
            sqlSession.commit();
        }
    }

    /**
     * 回滚事务
     * @param sqlSession
     */
    public static void rollbackSession(SqlSession sqlSession) {
        if (sqlSession != null) {
            sqlSession.rollback();
        }
    }

}