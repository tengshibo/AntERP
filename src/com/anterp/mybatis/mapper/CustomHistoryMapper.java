package com.anterp.mybatis.mapper;

import com.anterp.mybatis.domain.CustomHistory;
import com.anterp.mybatis.domain.CustomHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomHistoryMapper {
    int countByExample(CustomHistoryExample example);

    int deleteByExample(CustomHistoryExample example);

    int insert(CustomHistory record);

    int insertSelective(CustomHistory record);

    List<CustomHistory> selectByExample(CustomHistoryExample example);

    int updateByExampleSelective(@Param("record") CustomHistory record, @Param("example") CustomHistoryExample example);

    int updateByExample(@Param("record") CustomHistory record, @Param("example") CustomHistoryExample example);
}