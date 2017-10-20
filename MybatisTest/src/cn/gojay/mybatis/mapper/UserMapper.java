package cn.gojay.mybatis.mapper;

import cn.gojay.mybatis.entity.User;

import java.util.List;

/**
 * mapper接口：提供CRUD方法
 * @author Gojay
 * @date 2017/10/20.
 */
public interface UserMapper {
    /**
     * 根据id查询用户信息
     * @param id
     * @return
     * @throws Exception
     */
    User getUserById(int id) throws Exception;
    /**
     * 根据用户名列查询用户列表
     * @param name
     * @return
     * @throws Exception
     */
    List<User> listUserByName(String name) throws Exception;
    /**
     * 添加用户信息
     * @param user
     * @return
     * @throws Exception
     */
    boolean insertUser(User user) throws Exception;
    /**
     * 删除用户信息
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteUser(int id) throws Exception;
    /**
     * 更新用户
     * @param user
     * @return
     * @throws Exception
     */
    boolean updateUser(User user)throws Exception;
}
