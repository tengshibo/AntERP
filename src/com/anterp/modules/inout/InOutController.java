package com.anterp.modules.inout;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.anterp.modules.Controllers;
import com.anterp.mybatis.domain.Account;
import com.anterp.mybatis.domain.AccountExample;
import com.anterp.mybatis.domain.AccountRole;
import com.anterp.mybatis.domain.AccountRoleExample;
import com.anterp.mybatis.domain.RoleExample;
import com.anterp.mybatis.mapper.AccountMapper;
import com.anterp.mybatis.mapper.AccountRoleMapper;
import com.anterp.mybatis.mapper.RoleMapper;
import com.anterp.tool.DateUtil;

@Controller
@RequestMapping("/door")
public class InOutController {

	@Autowired
	private AccountMapper accountMapper;

	@Autowired
	private AccountRoleMapper accountRoleMapper;

	@RequestMapping("/check")
	public String check(@RequestParam("accName") String accName,
			@RequestParam("accPwd") String accPwd, Model model,
			HttpSession httpSession) throws JsonGenerationException,
			JsonMappingException, IOException {
		AccountExample example = new AccountExample();
		example.createCriteria().andAccnameEqualTo(accName)
				.andAccpwdEqualTo(accPwd);
		List<Account> accounts = accountMapper.selectByExample(example);

		if (accounts.size() == 1) {
			if ("123456".equals(accPwd)) {
				Controllers.setError(model, "Inout.002", "请修改密码，默认密码不允许登陆.");
				return Controllers.JsonViewName;
			}

			Account account = accounts.get(0);
			// session里需要存放 "账户信息"
			httpSession.setAttribute(Controllers.AccInfo, account);

			ObjectMapper objectMapper = new ObjectMapper();
			String accountInfoJson = objectMapper.writeValueAsString(account);
			httpSession.setAttribute(Controllers.AccInfoJson, accountInfoJson);

			// session里还需要存放 "权限信息"(TODO)， 先放入RoleInfo代替pvg
			AccountRoleExample arExample = new AccountRoleExample();
			arExample.createCriteria().andAccidEqualTo(account.getAccid());
			List<AccountRole> accRole = this.accountRoleMapper
					.selectByExample(arExample);
			String roleInfoJson = objectMapper.writeValueAsString(accRole
					.get(0));
			httpSession.setAttribute(Controllers.RoleInfoJson, roleInfoJson);

			Controllers.setSuccess(model);
			model.addAttribute("jsessionid", httpSession.getId());
		} else {
			// TODO 临时先这么返回错误
			Controllers.setError(model, "Inout.001",
					"Account or password error.");
		}
		return Controllers.JsonViewName;
	}

	@RequestMapping("/in")
	public String checkIn(HttpSession httpSession) {
		if (httpSession.getAttribute(Controllers.AccInfo) != null) {
			// return "redirect:http://www.baidu.com";
			// return "forward:/WEB-INF/modules/init/main.jsp";
			// 在web-inf下面无法redirect， 除非放出去,那样得加过滤器， 没登录不让访问jsp
			return "redirect:/modules/init/main.jsp";
			// return "redirect:/test.html";
			// 这个用viewResolver 也可以(OK)
			// return "modules/init/main";
		}
		return "redirect:" + Controllers.IndexJSP;
	}

	@RequestMapping("/out")
	public String checkOut(HttpSession httpSession) {
		httpSession.invalidate();
		return "redirect:" + Controllers.IndexJSP;
	}

	@RequestMapping("/updatePwd")
	public String updateAccountPwd(@RequestParam("accName") String accName,
			@RequestParam("originPwd") String originPwd,
			@RequestParam("newPwd") String newPwd, Model model) {
		AccountExample example = new AccountExample();
		example.createCriteria().andAccnameEqualTo(accName)
				.andAccpwdEqualTo(originPwd);
		List<Account> accounts = accountMapper.selectByExample(example);
		if (accounts.size() == 1) {
			Account account = accounts.get(0);
			Account accObj = new Account();
			accObj.setAccid(account.getAccid());
			accObj.setAccpwd(newPwd);
			accObj.setLastmodifytime(DateUtil.getCurrentTime());
			this.accountMapper.updateByPrimaryKeySelective(accObj);
			Controllers.setSuccess(model);
		} else {
			Controllers.setError(model, "Inout.002", "修改密码失败，帐户名或者密码错误.");
		}
		return Controllers.JsonViewName;
	}
}
