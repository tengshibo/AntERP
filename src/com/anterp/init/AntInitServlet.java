package com.anterp.init;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AntInitServlet extends DispatcherServlet {

	private static final long serialVersionUID = 5588699423164431002L;

	private static WebApplicationContext app = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("AntERP servlet init:" + app);
	}

	@Override
	public void destroy() {
		System.out.println("AntERP servlet end:" + app);
		super.destroy();
	}

	/**
	 * In order to get the WebApplicationContext in "init" method, need do this.
	 */
	@Override
	protected WebApplicationContext initWebApplicationContext() {
		app = super.initWebApplicationContext();
		return app;
	}
}
