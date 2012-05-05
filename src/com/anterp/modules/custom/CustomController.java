package com.anterp.modules.custom;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.anterp.modules.Controllers;
import com.anterp.modules.Pagers;
import com.anterp.mybatis.domain.Custom;
import com.anterp.mybatis.domain.CustomExample;
import com.anterp.mybatis.mapper.CustomMapper;
import com.anterp.tool.DateUtil;
import com.anterp.tool.JsonUtil;

@Controller
@RequestMapping("/modules/custom")
public class CustomController {

	private Logger logger = Logger.getLogger(CustomController.class);

	@Autowired
	private CustomMapper customMapper;

	@Autowired
	@Qualifier("anterpSqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	@RequestMapping("/getAll")
	public String getAllCustom(
			@RequestParam("page") int page,
			@RequestParam("rows") int rows,
			@RequestParam(value = "searchName", required = false) String searchName,
			@RequestParam(value = "searchPhone", required = false) String searchPhone,
			Model model) {

		System.out.println(searchName + "," + searchPhone);

		// 查询条件
		CustomExample example = new CustomExample();
		if (searchName != null) {
			example.createCriteria().andCustnameLikeInsensitive(
					"%" + searchName + "%");
		}
		if (searchPhone != null) {
			example.createCriteria().andPhonenoLikeInsensitive(
					"%" + searchPhone + "%");
		}
		customMapper.selectByExample(example);
		// 分页参数
		RowBounds rowBounds = new RowBounds(Pagers.getOffset(page, rows), rows);
		int totalNumber = customMapper.countByExample(example);

		example.setOrderByClause("lastmodifytime DESC");
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
	public String createCustom(@RequestParam("custom") String customStr,
			Model model) {
		try {
			Timestamp now = DateUtil.getCurrentTime();
			Custom custom = null;
			custom = JsonUtil.getObject(Custom.class, customStr);
			custom.setCreatetime(now);
			custom.setLastmodifytime(now);
			this.customMapper.insert(custom);
			Controllers.setSuccess(model);
		} catch (Throwable e) {
			logger.error("Create custom error", e);
			Controllers.setError(model, "custom.001", "Create custom error.");
		}
		return Controllers.JsonViewName;
	}

	@RequestMapping("/update")
	public String updateCustom(@RequestParam("custom") String customStr,
			Model model) {
		try {
			Timestamp now = DateUtil.getCurrentTime();
			Custom custom = null;
			custom = JsonUtil.getObject(Custom.class, customStr);
			custom.setLastmodifytime(now);
			this.customMapper.updateByPrimaryKey(custom);
			Controllers.setSuccess(model);
		} catch (Throwable e) {
			logger.error("Update custom error", e);
			Controllers.setError(model, "custom.002", "Update custom error.");
		}
		return Controllers.JsonViewName;
	}

	@RequestMapping("/delete")
	public String deleteCustom(@RequestParam("custId") int custId, Model model) {
		try {
			this.customMapper.deleteByPrimaryKey(custId);
			Controllers.setSuccess(model);
		} catch (Throwable t) {
			logger.error("Delete custom error", t);
			Controllers.setError(model, "custom.003", "Delete custom error.");
		}
		return Controllers.JsonViewName;
	}
}
