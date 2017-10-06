package aop.test;

//import aop.xml.service.UserService;
import aop.config.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Gojay on 2017/10/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:aop-xml.xml")
@ContextConfiguration("classpath:aop-config.xml")
public class AOPTest {

    @Resource(name="userService")
    private UserService userService;

    @Test
    public void aopTest(){
        userService.save();
        userService.delete();
    }
}
