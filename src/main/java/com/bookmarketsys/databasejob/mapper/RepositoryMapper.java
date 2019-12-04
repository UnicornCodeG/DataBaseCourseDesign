package com.bookmarketsys.databasejob.mapper;

import com.bookmarketsys.databasejob.pojo.Repository;
import com.bookmarketsys.databasejob.pojo.RepositoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RepositoryMapper {
    int countByExample(RepositoryExample example);

    int deleteByExample(RepositoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Repository record);

    int insertSelective(Repository record);

    List<Repository> selectByExample(RepositoryExample example);

    Repository selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Repository record, @Param("example") RepositoryExample example);

    int updateByExample(@Param("record") Repository record, @Param("example") RepositoryExample example);

    int updateByPrimaryKeySelective(Repository record);

    int updateByPrimaryKey(Repository record);
}