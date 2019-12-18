package com.bookmarketsys.databasejob.controller;


import com.bookmarketsys.databasejob.mapper.BookDetailMapper;
import com.bookmarketsys.databasejob.mapper.BookMapper;
import com.bookmarketsys.databasejob.pojo.Book;
import com.bookmarketsys.databasejob.service.serviceImpl.BookAdminOprServiceImpl;
import com.bookmarketsys.databasejob.util.Result;
import com.bookmarketsys.databasejob.util.ResultEnum;
import com.bookmarketsys.databasejob.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 处理图书管理员页面发送的请求
 */
@RestController
public class BookAdminController {

    @Autowired
    BookMapper bookMapper;
    @Autowired
    BookDetailMapper bookDetailMapper;
    @Autowired
    BookAdminOprServiceImpl bookAdminOprService;


    @RequestMapping("/deleteBook")
    Result deleteBook(@RequestBody Book book) {
        // Result deleteResult=new Result();
        try {
            bookAdminOprService.deleteBook(book.getId());

        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.ERROR.getCode(), "服务器开小差了");
        }
        return ResultUtil.success("删除书本成功");


    }


    @RequestMapping("/addBook")
    Result addBook(@RequestBody Book book) {
        try {
            bookAdminOprService.addBook(book);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.ERROR.getCode(), "服务器开小差了");
        }
        return ResultUtil.success("添加书本成功");

    }


    @RequestMapping("/selectBook")
    Result selectBook(@RequestBody Book book) {
        Book book1 = new Book();
        try {
            book1 = bookAdminOprService.selectBook(book.getId());
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.ERROR.getCode(), "服务器开小差了，查询失败");
        }
        return ResultUtil.success(book1);

    }

    @RequestMapping("/upDateBook")
    Result updateBook(@RequestBody Book book) {
        Book book1 = new Book();
        try {
            book1 = bookAdminOprService.updateBook(book);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.ERROR.getCode(), "服务器开小差了,更新失败");
        }
        return ResultUtil.success("更新成功");
    }
    @RequestMapping("/selectAllBook")
    Result selectAllBook(){
        List<Book> books ;

        try {
            books= bookAdminOprService.selectAllBook();
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.ERROR.getCode(),"服务器开小差了");
        }
        return ResultUtil.success(books);

    }

    @RequestMapping("/selectBookByMenuId")
    Result selectBookByMenuId(Integer menuId){

        List<Book> bookList = bookAdminOprService.selectBookByMenuId(menuId);

        return ResultUtil.success(bookList);

    }
    @RequestMapping("/selectBookLike")
    Result selectBookLike(String bookName){
        List<Book> books ;

        try {
            books= bookAdminOprService.selectBookLike(bookName);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.ERROR.getCode(),"服务器开小差了");
        }
        return ResultUtil.success(books);

    }

}





