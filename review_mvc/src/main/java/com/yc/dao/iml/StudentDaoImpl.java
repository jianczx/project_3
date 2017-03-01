package com.yc.dao.iml;


import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.yc.bean.Student;
import com.yc.dao.StudentDao;

//spring托管
@Repository
public  class StudentDaoImpl implements StudentDao{

	@Override
	public Student add(Student student) {
		AtomicLong generator=new AtomicLong();
		Long sid=generator.getAndIncrement();
		
		student.setSid(sid);
		
		return student;
	}

	@Override
	public List findAll(Object t, String sqlid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findAll(Object t, Map map, String sqlid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Object t, String sqlid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(Object t, Map map, String sqlid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addMore(Object t, List list, String sqlid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object t, String sqlid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object t, Map map, String sqlid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMore(Object t, List list, String sqlid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Object t, String sqlid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Object t, Map map, String sqlid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMore(Object t, List list, String sqlid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double findFun(Object t, String sqlid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double findFun(Object t, Map map, String sqlid) {
		// TODO Auto-generated method stub
		return 0;
	}
}
