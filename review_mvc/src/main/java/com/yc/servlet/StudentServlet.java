package com.yc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yc.bean.Student;
import com.yc.biz.StudentBiz;

public class StudentServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op=req.getParameter("op");
		if(op.equals("add")){			//分发
			try {
				add(req,resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void add(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String sname=req.getParameter("sname");
		req.setCharacterEncoding("utf-8");
		System.out.println("姓名为："+sname);
		
		Student s=new Student();
		s.setSname(sname);
		ApplicationContext  ac=new ClassPathXmlApplicationContext("beans.xml");
		//读取studentBizImpl这个类
		StudentBiz sb=(StudentBiz) ac.getBean("studentBizImpl");
		sb.add(s);
		Student student=sb.add(s);
		req.getSession().setAttribute("student", student);
		
		req.getRequestDispatcher("show.jsp").forward(req, resp);
	}

}
