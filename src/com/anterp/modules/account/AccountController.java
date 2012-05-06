package com.anterp.modules.account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.anterp.mybatis.domain.AccountRole;
import com.anterp.mybatis.domain.AccountRoleExample;
import com.anterp.mybatis.mapper.AccountMapper;
import com.anterp.mybatis.mapper.AccountRoleMapper;
import com.anterp.tool.DateUtil;
import com.anterp.tool.JsonUtil;

@Controller
@RequestMapping("/modules/account")
public class AccountController {

	private Logger logger = Logger.getLogger(AccountController.class);

	@Autowired
	private AccountMapper accountMapper;
	
	@Autowired
	private AccountRoleMapper accRoleMapper;

	@Autowired
	@Qualifier("anterpSqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	@RequestMapping("/getAll")
	public String getAllAccount(
			@RequestParam("page") int page,
			@RequestParam("rows") int rows,
			@RequestParam(value = "account", required = false) String accountStr,
			Model model) {
		try {
			AccountExample example = new AccountExample();
			example.setOrderByClause("lastmodifytime DESC");
			if (accountStr != null) {
				Account account = JsonUtil.getObject(Account.class, accountStr);
				Criteria createCriteria = example.createCriteria();

				if (account.getAccname() != null
						&& !"".equals(account.getAccname()))
					createCriteria.andAccnameLike("%" + account.getAccname()
							+ "%");
				if (account.getEmpname() != null
						&& !"".equals(account.getEmpname()))
					createCriteria.andEmpnameLike("%" + account.getEmpname()
							+ "%");
				if (account.getPhoneno() != null
						&& !"".equals(account.getPhoneno()))
					createCriteria.andPhonenoLike("%" + account.getPhoneno()
							+ "%");
			}
			// 分页参数
			RowBounds rowBounds = new RowBounds(Pagers.getOffset(page, rows),
					rows);
			int totalNumber = accountMapper.countByExample(example);

			@SuppressWarnings("unchecked")
			List<Account> accounts = (List<Account>) sqlSessionTemplate
					.selectList(
							"com.anterp.mybatis.mapper.AccountMapper.selectByExample",
							example, rowBounds);
			
			List<Integer> accIdList = new ArrayList<Integer>();
			for(Account acc : accounts){			
				accIdList.add(acc.getAccid());
			}
			//查询角色信息
			AccountRoleExample arexa=new AccountRoleExample();
			arexa.createCriteria().andAccidIn(accIdList);
			
			List<AccountRole> accRoleList =accRoleMapper.selectByExample(arexa);
			
			List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
			
		   //返回结果.	
			for(Account acc : accounts){
				Map<String,Object> rec = new HashMap<String,Object>();
				rec.put("accid",acc.getAccid());
				rec.put("accname", acc.getAccname());
				rec.put("address", acc.getAddress());
				rec.put("age",acc.getAge());
				rec.put("empname",acc.getEmpname());
				rec.put("phoneno", acc.getPhoneno());
				rec.put("gender",acc.getGender());
				rec.put("status",acc.getStatus());
				rec.put("urgentphone",acc.getUrgentphone());
				
				for(AccountRole accRole:accRoleList){
					if(accRole.getAccid()==acc.getAccid())
						rec.put("roleid",accRole.getRoleid());
				}
								
				result.add(rec);
			}

			model.addAttribute("rows", result);
			model.addAttribute("page", page);
			model.addAttribute("total", Pagers.getTotalPage(totalNumber, rows));
			model.addAttribute("records", totalNumber);
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug("查询失败!");
			Controllers.setError(model, "002", "查询失败!");
		}
		return Controllers.JsonViewName;
	}

	@RequestMapping("/delAccount")
	public String delAccount(@RequestParam("accId") int accountId
			              ,Model model) {

		//从权限表删除.
		AccountRoleExample example = new AccountRoleExample();
		example.createCriteria().andAccidEqualTo(accountId);
		accRoleMapper.deleteByExample(example);
		//从账户表删除.
		accountMapper.deleteByPrimaryKey(accountId);
		
		Controllers.setSuccess(model);
		
		return Controllers.JsonViewName;
	}

	@RequestMapping("/addAccount")
	public String addAccount(@RequestParam("account") String accountStr,
			@RequestParam("accrole") String accroleStr,
			Model model) {
		try {
			Account account = JsonUtil.getObject(Account.class, accountStr);
			account.setCreatetime(DateUtil.getCurrentTime());
			account.setLastmodifytime(DateUtil.getCurrentTime());
			account.setAccpwd("123456");
			accountMapper.insert(account);
			
			AccountExample accexa=new AccountExample();
			accexa.createCriteria().andAccnameEqualTo(account.getAccname());
			List<Account> accList = accountMapper.selectByExample(accexa);
			
			if(accList!=null &&accList.size()>0){
				AccountRole accrole =JsonUtil.getObject(AccountRole.class, accroleStr);
				accrole.setAccid(accList.get(0).getAccid());
				accRoleMapper.insert(accrole);
			}
		
			Controllers.setSuccess(model);
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug("添加账户失败!");
			Controllers.setError(model, "002", "添加账户失败!");
		}
		return Controllers.JsonViewName;
	}
  
	@RequestMapping("/updateAccount")
	public String updateAccount(@RequestParam("account") String accountStr,
			@RequestParam("accrole") String accroleStr,
			Model model) {
		try {
			Account account = JsonUtil.getObject(Account.class, accountStr);
			AccountRole accrole =JsonUtil.getObject(AccountRole.class, accroleStr);
			account.setLastmodifytime(DateUtil.getCurrentTime());
			
			accountMapper.updateByPrimaryKeySelective(account);
			//更新角色信息.
			AccountRoleExample example = new AccountRoleExample();
			example.createCriteria().andAccidEqualTo(account.getAccid());			
			accRoleMapper.updateByExampleSelective(accrole, example);
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug("修改账户失败!");
			Controllers.setError(model, "002", "修改账户失败!");
		}
		return Controllers.JsonViewName;
	}

}
