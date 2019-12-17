package com.bookmarketsys.databasejob.service.serviceImpl;

import com.bookmarketsys.databasejob.mapper.BookDetailMapper;
import com.bookmarketsys.databasejob.mapper.BookMapper;
import com.bookmarketsys.databasejob.mapper.MenuMapper;
import com.bookmarketsys.databasejob.pojo.*;
import com.bookmarketsys.databasejob.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName IndexServiceImpl
 * @Description
 * @Author 龚佳民
 * @Date 2019/12/5
 **/
@Service
public class IndexServiceImpl implements IndexService {


    @Autowired
    BookMapper bookMapper;
    @Autowired
    BookDetailMapper bookDetailMapper;
    @Autowired
    MenuMapper menuMapper;

    //展示图书简要信息,根据类型查询
    @Override
    public List<Book> showIndexBook(Integer menuId) {
        BookExample bookExample = new BookExample();
        bookExample.createCriteria().andMenuIdEqualTo(menuId);
        List<Book> books = bookMapper.selectByExample(bookExample);
        return books;
    }

    //展示图书详细信息
    @Override
    public BookDetail showIndexBookDetail(Integer bookId) {
        BookDetailExample bookDetailExample = new BookDetailExample();
        bookDetailExample.createCriteria().andBookIdEqualTo(bookId);
        BookDetail bookDetail = bookDetailMapper.selectByExample(bookDetailExample).get(0);
        return bookDetail;
    }

    @Override
    public List<Menu> showMenu() {
        MenuExample menuExample = new MenuExample();
        return menuMapper.selectByExample(menuExample);
    }

    @Override
    public List<Book> searchBook(String bookName){
        BookExample bookExample = new BookExample();
        bookExample.createCriteria().andNameLike(bookName);
        List<Book> bookList = bookMapper.selectByExample(bookExample);
        return bookList;
    }
}
