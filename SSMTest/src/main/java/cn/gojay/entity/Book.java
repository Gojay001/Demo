package cn.gojay.entity;

/**
 * @author Gojay
 * @date 2017/10/20.
 */
public class Book {
    private int bookId;
    private String name;
    private String detail;

    public Book() {}

    public Book(String name, String detail) {
        this.name = name;
        this.detail = detail;
    }

    public Book(int bookId, String name, String detail) {
        this.bookId = bookId;
        this.name = name;
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", name='" + name + '\'' +
                ", details='" + detail + '\'' +
                '}';
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetails(String detail) {
        this.detail = detail;
    }
}
