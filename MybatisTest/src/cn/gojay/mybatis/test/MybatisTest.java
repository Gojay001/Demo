package cn.gojay.mybatis.test;

import cn.gojay.mybatis.entity.User;
import cn.gojay.mybatis.mapper.UserMapper;
import cn.gojay.mybatis.tool.InitTool;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Mybatis测试类：CRUD
 * @author Gojay
 * @date 2017/10/20.
 */
public class MybatisTest {
    private SqlSession sqlSession;

    // 根据id查询用户信息，得到一条记录结果
    @Test
    public void getUserByIdTest() throws IOException {
        // 根据配置文件得到SqlSession
        sqlSession = InitTool.getSqlSession();
        // 通过SqlSession操作数据库
        // 第一个参数：映射文件中statement的id
        // 第二个参数：指定和映射文件中所匹配的parameterType类型的参数
        // sqlSession.selectOne结果是与映射文件中所匹配的resultType类型的对象
        // selectOne查询出一条记录
        User user = sqlSession.selectOne("findUserById", 1);
        System.out.println(user);
        // 释放资源
        sqlSession.close();
    }

    // 根据用户名称模糊查询用户列表
    @Test
    public void listUserByNameTest() throws IOException {
        // 根据配置文件得到SqlSession
        sqlSession = InitTool.getSqlSession();
        // list中的user和映射文件中resultType所指定的类型一致
        List<User> userList = sqlSession.selectList("findUserByName", "t");
        System.out.println(userList);
        sqlSession.close();
    }

    // 添加用户信息
    @Test
    public void insertUserTest() throws IOException {
        sqlSession = InitTool.getSqlSession();
        // 插入用户对象
        User user = new User("admin", "admin");
        sqlSession.insert("insertUser", user);
        // 提交事务
        sqlSession.commit();
        // 关闭会话
        sqlSession.close();
    }

    // 根据id删除用户信息
    @Test
    public void deleteUserTest() throws IOException {
        sqlSession = InitTool.getSqlSession();
        // 传入id删除用户
        sqlSession.delete("deleteUser", 3);
        sqlSession.commit();
        sqlSession.close();
    }

    // 更新用户信息
    @Test
    public void updateUserTest() throws IOException {
        sqlSession = InitTool.getSqlSession();
        User user = sqlSession.selectOne("getUserById", 1);
        user.setPassword("new password");
        sqlSession.update("updateUser", user);
        sqlSession.commit();
        sqlSession.close();
    }

    // 通过mapper接口实现映射
    @Test
    public void testGetUserById() throws Exception{
        sqlSession = InitTool.getSqlSession();
        //创建UserMapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用userMapper的方法
        User user = userMapper.getUserById(1);
        System.out.println(user.getName());
    }
}
