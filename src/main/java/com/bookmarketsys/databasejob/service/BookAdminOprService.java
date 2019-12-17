package com.bookmarketsys.databasejob.service;


import com.bookmarketsys.databasejob.pojo.Book;

import java.util.List;

/**
 * methods for Book Administrators to operate
 *
 * 2019-12-5 chenliang
 */
public interface BookAdminOprService {

    Book addBook(Book  book );
    Book deleteBook(int id);
    Book updateBook(Book book);
    Book selectBook(int id);
    List<Book> selectAllBook();


}
