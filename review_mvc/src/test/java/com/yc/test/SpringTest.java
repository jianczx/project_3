package com.yc.test;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yc.bean.Student;
import com.yc.biz.StudentBiz;
import com.yc.biz.impl.StudentBizImpl;

import junit.framework.TestCase;

public class SpringTest extends TestCase {

	@Test
	public void testSpring(){
		Student s=new Student();
		s.setSname("abc");
		ApplicationContext  ac=new ClassPathXmlApplicationContext("beans.xml");
		//读取studentBizImpl这个类
		StudentBiz sb=(StudentBiz) ac.getBean("studentBizImpl");
		sb.add(s);
		sb.add(s);
		System.out.println(s.getSname()+"  "+ s.getSid());
	}
	
	@Test
	public void testSpring1(){
		
		ApplicationContext  ac=new ClassPathXmlApplicationContext("beans.xml");
		DataSource ds=(DataSource) ac.getBean("dataSource");
		System.out.println(ds);
	}
	
	@Test
	public void testSpring2(){
		ApplicationContext  ac=new ClassPathXmlApplicationContext("beans.xml");
		Object ds=ac.getBean("sqlSessionFactory");
		System.out.println(ds);
	}
	
	
	@Test
	public void testSpring3(){
		ApplicationContext  ac=new ClassPathXmlApplicationContext("beans.xml");
		StudentBiz ds=(StudentBiz) ac.getBean("studentBizImpl");
		Student s=new Student();
		s.setSname("aabb");
		ds.add(s);
		System.out.println(s.getSname()+"  "+s.getSid());
	}
		
}
