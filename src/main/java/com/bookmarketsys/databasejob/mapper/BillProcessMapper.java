package com.bookmarketsys.databasejob.mapper;

import com.bookmarketsys.databasejob.pojo.BillProcess;
import com.bookmarketsys.databasejob.pojo.BillProcessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BillProcessMapper {
    int countByExample(BillProcessExample example);

    int deleteByExample(BillProcessExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BillProcess record);

    int insertSelective(BillProcess record);

    List<BillProcess> selectByExample(BillProcessExample example);

    BillProcess selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BillProcess record, @Param("example") BillProcessExample example);

    int updateByExample(@Param("record") BillProcess record, @Param("example") BillProcessExample example);

    int updateByPrimaryKeySelective(BillProcess record);

    int updateByPrimaryKey(BillProcess record);
}