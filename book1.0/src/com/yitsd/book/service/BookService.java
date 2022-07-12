package com.yitsd.book.service;

import com.yitsd.book.pojo.Book;

import java.util.List;

public interface BookService {

    List<Book> getBookList();

    Book getBook(Integer id);
}
