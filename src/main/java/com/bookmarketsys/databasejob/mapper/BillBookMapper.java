package com.bookmarketsys.databasejob.mapper;

import com.bookmarketsys.databasejob.pojo.BillBook;
import com.bookmarketsys.databasejob.pojo.BillBookExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BillBookMapper {
    int countByExample(BillBookExample example);

    int deleteByExample(BillBookExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BillBook record);

    int insertSelective(BillBook record);

    List<BillBook> selectByExample(BillBookExample example);

    BillBook selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BillBook record, @Param("example") BillBookExample example);

    int updateByExample(@Param("record") BillBook record, @Param("example") BillBookExample example);

    int updateByPrimaryKeySelective(BillBook record);

    int updateByPrimaryKey(BillBook record);
}