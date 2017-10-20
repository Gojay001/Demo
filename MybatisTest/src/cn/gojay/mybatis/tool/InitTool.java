package cn.gojay.mybatis.tool;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 初始化SqlSession工具类
 * @author Gojay
 * @date 2017/10/20.
 */
public class InitTool {
    public static SqlSessionFactory getSqlSessionFactory() throws IOException {
        // 1.mybatis配置文件
        String resource = "mybatis-config.xml";
        // 2.得到配置文件流
        InputStream inputStream =  Resources.getResourceAsStream(resource);
        // 3.创建会话工厂，传入mybatis配置文件的信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }

    public static SqlSession getSqlSession() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        // 通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }
}
