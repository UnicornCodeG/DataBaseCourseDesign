package com.bookmarketsys.databasejob.service;

import org.springframework.web.multipart.MultipartFile;


public interface importBookImpl {
    /**
     * 从excel导入数据到网络服务器或者本地数据库
     * @param file
     */
    String readEcellFile(MultipartFile file);
}
