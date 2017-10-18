package cn.gojay.mvc.service.impl;

import cn.gojay.mvc.entity.User;
import cn.gojay.mvc.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author Gojay
 * @date 2017/10/18.
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public User getUser() {
        User user = new User();
        user.setId(1);
        user.setName("user1");
        return user;
    }
}
