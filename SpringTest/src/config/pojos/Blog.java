package config.pojos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Gojay on 2017/10/5.
 */
@Component("blog3")
public class Blog {
    private int id;
    private String title;

    //getter、setter
    public int getId() {
        return id;
    }

    @Value("3")
    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    @Value("test3")
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "[Blog]: id = " + id + ", title = " + title;
    }
}
