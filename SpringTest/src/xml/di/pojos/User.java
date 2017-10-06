package xml.di.pojos;

/**
 * Created by Gojay on 2017/10/5.
 */
public class User {
    private int id;
    private String name;
    private Blog blog;

    public User() {
    }

    public User(int id, String name, Blog blog) {
        this.id = id;
        this.name = name;
        this.blog = blog;
    }

    public void init(){
        System.out.println("初始化User");
    }

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
