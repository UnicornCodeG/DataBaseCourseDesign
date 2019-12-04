package com.bookmarketsys.databasejob;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bookmarketsys.databasejob.mapper")
public class DatabasejobApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatabasejobApplication.class, args);
    }

}
