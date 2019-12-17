package com.bookmarketsys.databasejob.controller;

import com.bookmarketsys.databasejob.pojo.Book;
import com.bookmarketsys.databasejob.pojo.BookDetail;
import com.bookmarketsys.databasejob.pojo.Menu;
import com.bookmarketsys.databasejob.service.IndexService;
import com.bookmarketsys.databasejob.util.Result;
import com.bookmarketsys.databasejob.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName IndexController
 * @Description
 * @Author 龚佳民
 * @Date 2019/12/5
 **/
@RestController
public class IndexController {

    @Autowired
    IndexService indexService;

    @RequestMapping("/showBook")
    public Result showBook(Integer menuId){
        List<Book> books = indexService.showIndexBook(menuId);
        return ResultUtil.success(books);
    }

    @RequestMapping("/showBookDetail")
    public Result showBookDetail(Integer bookId){
        BookDetail bookDetail = indexService.showIndexBookDetail(bookId);
        return ResultUtil.success(bookDetail);
    }

    @RequestMapping("/showMenu")
    public Result showMenu(){
        List<Menu> menus = indexService.showMenu();
        return ResultUtil.success(menus);
    }

    @RequestMapping("/searchBook")
    public Result searchBook(String bookName){
        List<Book> bookList = indexService.searchBook(bookName);
        return ResultUtil.success(bookList);
    }
}
