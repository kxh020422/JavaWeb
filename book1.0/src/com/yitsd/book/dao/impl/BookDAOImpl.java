package com.yitsd.book.dao.impl;

import com.yitsd.book.dao.BookDAO;
import com.yitsd.book.pojo.Book;
import com.yitsd.myssm.basedao.BaseDAO;

import java.util.List;

/**
 * @ClassName BookDAOImpl
 * @Date 2022/7/6 20:23
 */
public class BookDAOImpl extends BaseDAO<Book> implements BookDAO {
    @Override
    public List<Book> getBookList() {
        return executeQuery("select * from t_book where bookStatus = 0");
    }

    @Override
    public Book getBook(Integer id) {
        return load("select * from t_book where id = ?", id);
    }
}
