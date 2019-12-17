package com.bookmarketsys.databasejob.service.serviceImpl;

import com.bookmarketsys.databasejob.mapper.BookMapper;
import com.bookmarketsys.databasejob.pojo.Book;
import com.bookmarketsys.databasejob.service.importBookImpl;
import com.bookmarketsys.databasejob.util.ReadExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public  class ImportBook implements importBookImpl {

    @Autowired BookMapper bookMapper;

    @Override
    public String readEcellFile(MultipartFile file) {
        String Result=null;
        ReadExcel readExcel=new ReadExcel();
        List<Book> bookList=readExcel.getExcelInfo(file);
        if(bookList!=null&&!bookList.isEmpty())
        {
            bookMapper.insert((Book) bookList);
            Result="上传成功";

        }
        else
        {
            Result="上传失败";
        }
        return Result;
    }
}
