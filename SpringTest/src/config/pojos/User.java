package config.pojos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
//import javax.annotation.Resource;

/**
 * Created by Gojay on 2017/10/5.
 */
@Component("user3")
public class User {

    //值注入
    @Value("3")
    private int id;
    @Value("admin3")
    private String name;

    //引用类型自动装配
    //@Resource(name="blog3")
    @Autowired
    @Qualifier("blog3")
    private Blog blog;

    @PostConstruct
    public void init(){
        System.out.println("初始化User");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("销毁User");
    }

    //getter、setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    @Override
    public String toString() {
        return "[User]: id = " + id + ", name = " + name + "\nblog = " + blog;
    }
}
