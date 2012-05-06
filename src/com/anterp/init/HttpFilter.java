package com.anterp.init;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anterp.modules.Controllers;
import com.anterp.modules.utils.ThreadLocalUtils;
import com.anterp.mybatis.domain.Account;

public class HttpFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		Account account = (Account) (httpRequest.getSession()
				.getAttribute(Controllers.AccInfo));
		if (account == null) {
			httpResponse.sendRedirect(httpRequest.getContextPath()
					+ Controllers.IndexJSP);
			return;
		} else {
			ThreadLocalUtils.setAccInfo(account);
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
