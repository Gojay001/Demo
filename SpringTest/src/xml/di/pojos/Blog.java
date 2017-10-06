package xml.di.pojos;

/**
 * Created by Gojay on 2017/10/5.
 */
public class Blog {
    private int id;
    private String title;

    //getter、setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "[Blog]: id = " + id + ", title = " + title;
    }
}

