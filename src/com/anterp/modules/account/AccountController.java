package com.anterp.modules.account;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anterp.modules.Controllers;
import com.anterp.mybatis.domain.AccountExample;
import com.anterp.mybatis.domain.Custom;

@Controller
@RequestMapping("/modules/account")
public class AccountController {

	@Autowired
	@Qualifier("anterpSqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	@RequestMapping("/getAll")
	public String getAllCustom() {
		AccountExample example = new AccountExample();
		example.createCriteria().andAccnameLike("%Ant%");
		// 分页参数
		RowBounds rowBounds = new RowBounds(0, 2);		
		@SuppressWarnings("unchecked")
		List<Custom> customs = (List<Custom>) sqlSessionTemplate.selectList(
				"com.anterp.mybatis.mapper.AccountMapper.selectByExample",
				example, rowBounds);		
		System.out.println(customs.size());
		return Controllers.JsonViewName;
	}
	

}
