package com.yitsd.book.service.impl;

import com.yitsd.book.dao.BookDAO;
import com.yitsd.book.pojo.Book;
import com.yitsd.book.service.BookService;

import java.util.List;

/**
 * @ClassName BookServiceImpl
 * @Date 2022/7/6 20:29
 */
public class BookServiceImpl implements BookService {

    private BookDAO bookDAO;

    @Override
    public List<Book> getBookList() {
        return bookDAO.getBookList();
    }

    @Override
    public Book getBook(Integer id) {
        return bookDAO.getBook(id);
    }
}
