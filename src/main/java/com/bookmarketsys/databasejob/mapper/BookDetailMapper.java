package com.bookmarketsys.databasejob.mapper;

import com.bookmarketsys.databasejob.pojo.BookDetail;
import com.bookmarketsys.databasejob.pojo.BookDetailExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookDetailMapper {
    int countByExample(BookDetailExample example);

    int deleteByExample(BookDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BookDetail record);

    int insertSelective(BookDetail record);

    List<BookDetail> selectByExample(BookDetailExample example);

    BookDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BookDetail record, @Param("example") BookDetailExample example);

    int updateByExample(@Param("record") BookDetail record, @Param("example") BookDetailExample example);

    int updateByPrimaryKeySelective(BookDetail record);

    int updateByPrimaryKey(BookDetail record);
}