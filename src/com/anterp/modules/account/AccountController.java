package com.anterp.modules.account;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.anterp.modules.Controllers;
import com.anterp.modules.Pagers;
import com.anterp.mybatis.domain.Account;
import com.anterp.mybatis.domain.AccountExample;
import com.anterp.mybatis.domain.Custom;
import com.anterp.mybatis.mapper.AccountMapper;
import com.anterp.tool.DateUtil;

@Controller
@RequestMapping("/modules/account")
public class AccountController {
	
	
	@Autowired
	private AccountMapper accountMapper;

	@Autowired
	@Qualifier("anterpSqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	@RequestMapping("/getAll")
	public String getAllAccount(@RequestParam("page") int page,
			@RequestParam("rows") int rows, Model model) {
		AccountExample example = new AccountExample();
		example.createCriteria().andAccnameLike("%Ant%");
		// 分页参数
		// 分页参数
		RowBounds rowBounds = new RowBounds(Pagers.getOffset(page, rows), rows);
		int totalNumber = accountMapper.countByExample(example);
	
		@SuppressWarnings("unchecked")
		List<Custom> customs = (List<Custom>) sqlSessionTemplate.selectList(
				"com.anterp.mybatis.mapper.AccountMapper.selectByExample",
				example, rowBounds);		
		model.addAttribute("rows", customs);
		model.addAttribute("page", page);
		model.addAttribute("total", Pagers.getTotalPage(totalNumber, rows));
		model.addAttribute("records", totalNumber);
		
		return Controllers.JsonViewName;
	}
	
	@RequestMapping("/delAccount")
	public void delAccount(@RequestParam("accId") int accountId){
		
		accountMapper.deleteByPrimaryKey(accountId);
	}
	
	@RequestMapping("/updateAccount")
	public String updateAccount(Account account, Model model){
		
		account.setLastmodifytime(DateUtil.getCurrentTime());
		accountMapper.updateByPrimaryKey(account);
		
		return Controllers.JsonViewName;
	}
	
	
	

}
