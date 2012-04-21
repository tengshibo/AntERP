package com.anterp.init;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AntContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("AntERP context init...");
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("AntERP context destroyed...");
	}

}
