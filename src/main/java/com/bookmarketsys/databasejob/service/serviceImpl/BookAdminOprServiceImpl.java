package com.bookmarketsys.databasejob.service.serviceImpl;

import com.bookmarketsys.databasejob.mapper.BookMapper;
import com.bookmarketsys.databasejob.mapper.MenuMapper;
import com.bookmarketsys.databasejob.pojo.Book;
import com.bookmarketsys.databasejob.pojo.BookExample;
import com.bookmarketsys.databasejob.service.BookAdminOprService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookAdminOprServiceImpl implements BookAdminOprService {

    @Autowired
    BookMapper bookMapper;
    @Autowired
    MenuMapper menuMapper;
    @Override
    public Book addBook(Book book) {
        bookMapper.insert(book);
        return book;
    }

    @Override
    public Book deleteBook (int id) {
        Book book=selectBook(id);
        if(book==null)return null;  //返回null,该书本不存在
        BookExample bookExample =new BookExample();
        bookExample.createCriteria().andIdEqualTo(id);
       int res= bookMapper.deleteByExample(bookExample);
       return book;



    }


    //
    @Override
    public Book updateBook(Book book) {
        Book book1=selectBook(book.getId());
        if(book1==null)return null;            //如果没有这本书，则返回null
       // BookExample bookExample=new BookExample();
        int res=bookMapper.updateByPrimaryKey(book);
        return book;                //返回更新结果

    }

    @Override
    public Book selectBook(int id) {

        BookExample bookExample=new BookExample();
        bookExample.createCriteria().andIdEqualTo(id);
        Book book =bookMapper.selectByPrimaryKey(id);
        return book;
    }

    @Override
    public List<Book> selectAllBook() {

            BookExample bookExample=new BookExample();
            bookExample.createCriteria().getAllCriteria();
            List<Book> books=bookMapper.selectByExample(bookExample);
            return books;
    }

    @Override
    public List<Book> selectBookByMenuId(Integer menuId) {
        BookExample bookExample = new BookExample();
        bookExample.createCriteria().andMenuIdEqualTo(menuId);
        List<Book> bookList = bookMapper.selectByExample(bookExample);
        for (Book book : bookList) {
            String menuName = menuMapper.selectByPrimaryKey(book.getMenuId()).getMenuName();
            book.setMenuName(menuName);
        }
        return bookList;
    }
    @Override
    public List<Book> selectBookLike(String bookName) {

        BookExample bookExample=new BookExample();
        bookExample.createCriteria().andNameLike(bookName);
        List <Book> bookList =bookMapper.selectByExample(bookExample);
        for (Book book : bookList) {
            String menuName = menuMapper.selectByPrimaryKey(book.getMenuId()).getMenuName();
            book.setMenuName(menuName);
        }
        return bookList;
    }

}
