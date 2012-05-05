package com.anterp.modules.account;

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
import com.anterp.mybatis.domain.Account;
import com.anterp.mybatis.domain.AccountExample;
import com.anterp.mybatis.domain.AccountExample.Criteria;
import com.anterp.mybatis.domain.Custom;
import com.anterp.mybatis.mapper.AccountMapper;
import com.anterp.tool.DateUtil;
import com.anterp.tool.JsonUtil;

@Controller
@RequestMapping("/modules/account")
public class AccountController {
	
	private Logger logger = Logger.getLogger(AccountController.class);
	
	@Autowired
	private AccountMapper accountMapper;

	@Autowired
	@Qualifier("anterpSqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	@RequestMapping("/getAll")
	public String getAllAccount(@RequestParam("page") int page,
			@RequestParam("rows") int rows,
			@RequestParam(value="account",required=false) String accountStr, 
			Model model) {
		try{
		AccountExample example = new AccountExample();
		example.setOrderByClause("lastmodifytime DESC");
		if(accountStr!=null){
		Account account = JsonUtil.getObject(Account.class, accountStr);		
		Criteria createCriteria = example.createCriteria();
		
		if(account.getAccname()!=null&&!"".equals(account.getAccname()))
			    createCriteria.andAccnameLike("%"+account.getAccname()+"%");
		if(account.getEmpname()!=null&&!"".equals(account.getEmpname()))
		    createCriteria.andEmpnameLike("%"+account.getEmpname()+"%");
		if(account.getPhoneno()!=null&&!"".equals(account.getPhoneno()))
		     createCriteria.andPhonenoLike("%"+account.getPhoneno()+"%");
		}
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
		}catch(Exception e){
			 e.printStackTrace();
			 logger.debug("查询失败!");
			 Controllers.setError(model, "002", "查询失败!");	
		}
		return Controllers.JsonViewName;
	}
	
	@RequestMapping("/delAccount")
	public void delAccount(@RequestParam("accId") int accountId){
		
		accountMapper.deleteByPrimaryKey(accountId);
	}
	
	
	@RequestMapping("/addAccount")
	public String addAccount(@RequestParam("account") String accountStr,Model model){
		try{
		Account account = JsonUtil.getObject(Account.class, accountStr);
		account.setCreatetime(DateUtil.getCurrentTime());
		account.setLastmodifytime(DateUtil.getCurrentTime());
		account.setAccpwd("123456");
		accountMapper.insert(account);
		Controllers.setSuccess(model);
		}catch(Exception e){
		 e.printStackTrace();
		 logger.debug("添加账户失败!");
		 Controllers.setError(model, "002", "添加账户失败!");
		}
		
		return Controllers.JsonViewName;
	}
	
	
	@RequestMapping("/updateAccount")
	public String updateAccount(@RequestParam("account") String accountStr, Model model){
		try{	
		Account account = JsonUtil.getObject(Account.class, accountStr);
		account.setLastmodifytime(DateUtil.getCurrentTime());
		//accountMapper.updateByPrimaryKey(account);
		accountMapper.updateByPrimaryKeySelective(account);
		}catch(Exception e){
			 e.printStackTrace();
			 logger.debug("添加账户失败!");
			 Controllers.setError(model, "002", "修改账户失败!");
		}
		return Controllers.JsonViewName;
	}
	
	
	

}
