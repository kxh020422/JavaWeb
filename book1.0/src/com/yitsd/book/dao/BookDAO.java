package com.yitsd.book.dao;

import com.yitsd.book.pojo.Book;

import java.util.List;

public interface BookDAO {
    List<Book> getBookList();

    Book getBook(Integer id);
}
