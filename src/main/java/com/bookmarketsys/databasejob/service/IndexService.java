package com.bookmarketsys.databasejob.service;


import com.bookmarketsys.databasejob.pojo.Book;
import com.bookmarketsys.databasejob.pojo.BookDetail;
import com.bookmarketsys.databasejob.pojo.Menu;

import java.util.List;

public interface IndexService {
    //展示图书商城的上架的图书（图片，简要的信息）
    List<Book> showIndexBook(Integer menuId);

    //查看图书详细信息，图书状态，库存
    BookDetail showIndexBookDetail(Integer bookId);

    //显示菜单
    List<Menu> showMenu();

    List<Book> searchBook(String bookName);
}
