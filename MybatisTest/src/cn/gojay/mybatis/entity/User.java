package cn.gojay.mybatis.entity;

/**
 * 用户实体类
 * @author Gojay
 * @date 2017/10/20.
 */
public class User {
    private int id;
    private String name;
    private String password;

    public User() {
    }

    public User(String username, String password) {

        this.name = username;
        this.password = password;
    }

    public User(int id, String username, String password) {

        this.id = id;
        this.name = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String username) {
        this.name = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
