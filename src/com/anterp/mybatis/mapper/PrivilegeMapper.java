package com.anterp.mybatis.mapper;

import com.anterp.mybatis.domain.Privilege;
import com.anterp.mybatis.domain.PrivilegeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PrivilegeMapper {
    int countByExample(PrivilegeExample example);

    int deleteByExample(PrivilegeExample example);

    int insert(Privilege record);

    int insertSelective(Privilege record);

    List<Privilege> selectByExample(PrivilegeExample example);

    int updateByExampleSelective(@Param("record") Privilege record, @Param("example") PrivilegeExample example);

    int updateByExample(@Param("record") Privilege record, @Param("example") PrivilegeExample example);
}