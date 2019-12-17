package com.bookmarketsys.databasejob.controller;

import com.bookmarketsys.databasejob.service.serviceImpl.ImportBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Controller
public class ImportBookController {
    @Autowired
    private ImportBook importBook;


    @RequestMapping(value = "/upload",method= RequestMethod.POST)
    @ResponseBody
    public  String upload(@RequestParam(value = "file",required = false)MultipartFile file, HttpServletRequest request, HttpServletResponse response)
    {
        String result=importBook.readEcellFile(file);
        return result;
    }
}
