package com.bookmarketsys.databasejob.serviceImpl;

import com.bookmarketsys.databasejob.mapper.BookMapper;
import com.bookmarketsys.databasejob.service.IndexService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName IndexServiceImplTest
 * @Description
 * @Author 龚佳民
 * @Date 2019/12/9
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class IndexServiceImplTest {
    @Autowired
    IndexService indexService;
    @Autowired
    BookMapper bookMapper;
    @Test
    public void test1(){
//        BookDetail bookDetail = indexService.showIndexBookDetail(1);
//        System.out.println(bookDetail.getContent());
//        BookExample bookExample = new BookExample();
//        List<Book> bookList = bookMapper.selectByExample(bookExample);
//        System.out.println(bookList.toString());

    }
}
