package com.anterp.modules;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping("/test.action")
	public void test(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		System.out.println("dddddddd");
		response.getWriter().write("You get it.");
	}

}
