package aop.config.service;

/**
 * Created by Gojay on 2017/10/6.
 */
public class UserServiceImpl implements UserService {
    @Override
    public void save() {
        System.out.println("保存用户！");
    }

    @Override
    public void delete() {
        System.out.println("删除用户！");
    }

    @Override
    public void update() {
        System.out.println("更改用户！");
    }

    @Override
    public void search() {
        System.out.println("查询用户！");
    }
}
