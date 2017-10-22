package cn.gojay.dao;

import cn.gojay.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Gojay
 * @date 2017/10/20.
 */
public interface BookDao {
    /**
     * 根据id获取Book
     * @param id
     * @return
     */
    Book getBook(int id);

    /**
     * 获取分页中该页所有Book
     * @param offset
     * @param limit
     * @return
     */
    List<Book> listBook(@Param("offset") int offset, @Param("limit") int limit);

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
