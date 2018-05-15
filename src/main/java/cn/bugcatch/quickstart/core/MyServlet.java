package cn.bugcatch.quickstart.core;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.boot.web.servlet.ServletRegistrationBean;

public class MyServlet implements Servlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.err.println("servlet init");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		System.err.println("servlet getServletConfig");
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.err.println("servlet service");
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		System.err.println("servlet getServletInfo");
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.err.println("servlet destroy");
	}

	

}
