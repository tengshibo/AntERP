package com.anterp.mybatis.mapper;

import com.anterp.mybatis.domain.RolePrivilege;
import com.anterp.mybatis.domain.RolePrivilegeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolePrivilegeMapper {
    int countByExample(RolePrivilegeExample example);

    int deleteByExample(RolePrivilegeExample example);

    int insert(RolePrivilege record);

    int insertSelective(RolePrivilege record);

    List<RolePrivilege> selectByExample(RolePrivilegeExample example);

    int updateByExampleSelective(@Param("record") RolePrivilege record, @Param("example") RolePrivilegeExample example);

    int updateByExample(@Param("record") RolePrivilege record, @Param("example") RolePrivilegeExample example);
}