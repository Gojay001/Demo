package cn.gojay.service;

import cn.gojay.entity.Book;

import java.util.List;

/**
 * @author Gojay
 * @date 2017/10/21.
 */
public interface BookService {
    /**
     * 根据id获取Book
     * @param id
     * @return
     */
    Book getBook(int id);

    /**
     * 获取分页中该页所有Book
     * @param start
     * @param pageNum
     * @return
     */
    List<Book> listBook(int start, int pageNum);

    /**
     * 根据Book对象新增Book
     * @param book
     * @return
     */
    boolean insertBook(Book book);

    /**
     * 更新Book信息
     * @param book
     * @return
     */
    boolean updateBook(Book book);

    /**
     * 根据id删除Book
     * @param id
     * @return
     */
    boolean deleteBook(int id);
}
