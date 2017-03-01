package com.yc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


public class DispacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.解析地址：  
		String 	uri=req.getRequestURI();
		//2.获取student.action
		String actionName=uri.substring(uri.lastIndexOf("/")+1);
		actionName=actionName.substring(0, actionName.lastIndexOf("."));
		//3.判断是否为student 如果是 则实例化 studentAction
		Action action=null;
		ApplicationContext ac=WebApplicationContextUtils.getWebApplicationContext(req.getServletContext());
		action=(Action) ac.getBean(actionName);
		/*if("student".equals(actionName)){
			action=new StudentAction();
		}else if("hello".equals(actionName)){
			
		}*/
		
		//4.调用action对象中的HandleRequest
		String dispacherUrl=null;
		if(action!=null){
			dispacherUrl=action.HandleRequest(req, resp);
		}
		
		//5.获取返回值
		//6.根据返回值  跳转页面
		if(dispacherUrl!=null){
			req.getRequestDispatcher("show.jsp").forward(req, resp);
		}else{
			req.getRequestDispatcher("404.jsp").forward(req, resp);
		}
	}
}
