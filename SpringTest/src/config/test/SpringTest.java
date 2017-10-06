package config.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import config.pojos.*;

/**
 * Created by Gojay on 2017/10/5.
 */
//创建容器
@RunWith(SpringJUnit4ClassRunner.class)
//指定配置文件
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class SpringTest {


    @Resource(name="user3")
    private User user;

    @Test
    public void test(){
        System.out.println(user);
    }

    /*
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        User user = (User) classPathXmlApplicationContext.getBean("user3");
        System.out.println(user);
        classPathXmlApplicationContext.close();
    }
    */
}
