package com.anterp.modules;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anterp.mybatis.domain.Role;
import com.anterp.mybatis.mapper.RoleMapper;

@Controller
public class TestController {
	
	@Autowired
	private RoleMapper rm;

	@RequestMapping("/test.action")
	public void test(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		List<Role> roles = rm.selectByExample(null);
		System.out.println(roles.size());
		System.out.println("dddddddd");
		response.getWriter().write("You get it.");
	}

}
