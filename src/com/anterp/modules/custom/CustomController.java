package com.anterp.modules.custom;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.anterp.modules.Controllers;
import com.anterp.modules.Pagers;
import com.anterp.mybatis.domain.Custom;
import com.anterp.mybatis.domain.CustomExample;
import com.anterp.mybatis.mapper.CustomMapper;
import com.anterp.tool.JsonUtil;

@Controller
@RequestMapping("/modules/custom")
public class CustomController {

	@Autowired
	private CustomMapper customMapper;

	@Autowired
	@Qualifier("anterpSqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	@RequestMapping("/getAll")
	public String getAllCustom(@RequestParam("page") int page,
			@RequestParam("rows") int rows, Model model) {
		// 查询条件
		CustomExample example = new CustomExample();
		customMapper.selectByExample(example);
		// 分页参数
		RowBounds rowBounds = new RowBounds(Pagers.getOffset(page, rows), rows);
		int totalNumber = customMapper.countByExample(example);
		@SuppressWarnings("unchecked")
		List<Custom> customs = (List<Custom>) sqlSessionTemplate.selectList(
				"com.anterp.mybatis.mapper.CustomMapper.selectByExample",
				example, rowBounds);

		model.addAttribute("rows", customs);
		model.addAttribute("page", page);
		model.addAttribute("total", Pagers.getTotalPage(totalNumber, rows));
		model.addAttribute("records", totalNumber);

		// System.out.println("page:" + page + ",rows:" + rows);
		// System.out.println(customs.size());
		return Controllers.JsonViewName;
	}
	
	

	@RequestMapping("/create")
	public String createCustom(@RequestParam("custom") String customStr, Model model) {
		System.out.println(customStr);
		Custom custom = JsonUtil.getObject(Custom.class, customStr);
		
		System.out.println(custom.getCustname());
		
		Timestamp now = new Timestamp(System.currentTimeMillis());
//		custom.setCreatetime(now);
//		custom.setLastmodifytime(now);
		// this.customMapper.insert(custom);
		return Controllers.JsonViewName;
	}
	
	@RequestMapping("/update")
	public String updateCustom(Custom custom, Model model) {
		System.out.println(custom.getCustname());
		Timestamp now = new Timestamp(System.currentTimeMillis());
		custom.setCreatetime(now);
		custom.setLastmodifytime(now);
		//this.customMapper.updateByPrimaryKey(custom);
		return Controllers.JsonViewName;
	}

	@RequestMapping("/delete")
	public String deleteCustom(@RequestParam("custId") int custId) {
		this.customMapper.deleteByPrimaryKey(custId);
		return Controllers.JsonViewName;
	}
}
