package com.anterp.mybatis.mapper;

import com.anterp.mybatis.domain.AccountRole;
import com.anterp.mybatis.domain.AccountRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccountRoleMapper {
    int countByExample(AccountRoleExample example);

    int deleteByExample(AccountRoleExample example);

    int insert(AccountRole record);

    int insertSelective(AccountRole record);

    List<AccountRole> selectByExample(AccountRoleExample example);

    int updateByExampleSelective(@Param("record") AccountRole record, @Param("example") AccountRoleExample example);

    int updateByExample(@Param("record") AccountRole record, @Param("example") AccountRoleExample example);
}