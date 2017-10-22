package cn.gojay.service.impl;

import cn.gojay.dao.BookDao;
import cn.gojay.entity.Book;
import cn.gojay.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Gojay
 * @date 2017/10/21.
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public Book getBook(int id) {
        return bookDao.getBook(id);
    }

    @Override
    public List<Book> listBook(int start, int pageNum) {
        return bookDao.listBook(start, pageNum);
    }

    @Override
    public boolean insertBook(Book book) {
        return bookDao.insertBook(book);
    }

    @Override
    public boolean updateBook(Book book) {
        return bookDao.updateBook(book);
    }

    @Override
    public boolean deleteBook(int id) {
        return bookDao.deleteBook(id);
    }
}
