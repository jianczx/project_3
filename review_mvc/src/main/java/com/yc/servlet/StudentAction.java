package com.yc.servlet;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.yc.bean.Student;
import com.yc.biz.StudentBiz;

//动作 一个·请求
@Component(value="student")
@Scope(value="prototype")
public class StudentAction implements Action{

	private StudentBiz studentBiz;
	
	public StudentAction(){
		System.out.println("构造方法");
	}
	
	
	@Resource(name="studentBizImpl")
	public void setStudentBiz(StudentBiz studentBiz) {
		this.studentBiz = studentBiz;
	}

	@Override
	public String HandleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		String op=request.getParameter("op");
		if(op.equals("add")){			//分发
			add(request,response);
			return "show.jsp";
		}
		return null;
	}

	private void add(HttpServletRequest request, HttpServletResponse response) {
		String sname=request.getParameter("sname");
		response.setCharacterEncoding("utf-8");
		System.out.println("姓名为："+sname);
		
		Student s=new Student();
		s.setSname(sname);
		//ApplicationContext  ac=new ClassPathXmlApplicationContext("beans.xml");
		//读取studentBizImpl这个类
		//StudentBiz sb=(StudentBiz) ac.getBean("studentBizImpl");
		s=studentBiz.add(s);
		//sb.add(s);
		//Student student=sb.add(s);
		request.getSession().setAttribute("student", s);
		
	}

}
