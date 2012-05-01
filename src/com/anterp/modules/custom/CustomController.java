package com.anterp.modules.custom;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anterp.modules.Controllers;
import com.anterp.mybatis.domain.Custom;
import com.anterp.mybatis.domain.CustomExample;
import com.anterp.mybatis.mapper.CustomMapper;

@Controller
@RequestMapping("/modules/custom")
public class CustomController {

	@Autowired
	private CustomMapper customMapper;

	@Autowired
	@Qualifier("anterpSqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	@RequestMapping("/getAll")
	public String getAllCustom() {
		CustomExample example = new CustomExample();
		customMapper.selectByExample(example);
		// 分页参数
		RowBounds rowBounds = new RowBounds(2, 2);
		
		@SuppressWarnings("unchecked")
		List<Custom> customs = (List<Custom>) sqlSessionTemplate.selectList(
				"com.anterp.mybatis.mapper.CustomMapper.selectByExample",
				example, rowBounds);
		System.out.println(customs.size());
		return Controllers.JsonViewName;
	}

}
