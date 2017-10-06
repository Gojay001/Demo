package xml.ioc.test;

//import User;
import xml.di.pojos.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Gojay on 2017/10/5.
 */
public class SpringTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-xml.xml");
        User user = (User) applicationContext.getBean("user2");
        System.out.println(user);
        applicationContext.close();
    }
}
