package cn.gojay.web;

import cn.gojay.entity.Book;
import cn.gojay.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Gojay
 * @date 2017/10/21.
 */
@Controller
@RequestMapping("/book")
public class BookController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private String list(Model model) {
        List<Book> list = bookService.listBook(0, 1000);
        model.addAttribute("list", list);
        return "list";
    }

    @RequestMapping(value = "/detail/{bookId}", method = RequestMethod.GET)
    private String detail(@PathVariable("bookId") int bookId, Model model) {
        Book book = bookService.getBook(bookId);
        model.addAttribute("book", book);
        return "detail";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    @ResponseBody
    private String insert(Book book) {
        Book hasBook = bookService.getBook(book.getBookId());
        boolean bool = false;
        if (hasBook == null) {
            bool = bookService.insertBook(book);
        }
        return bool == true ? "success" : "error";
    }

    @RequestMapping(value = "/delete/{bookId}", method = RequestMethod.GET)
    @ResponseBody
    private String deleteBookById(@PathVariable("bookId") int id) {
        boolean bool = bookService.deleteBook(id);
        return bool == true ? "success" : "error";
    }
}
