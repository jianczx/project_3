package com.yc.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.bean.Student;
import com.yc.biz.StudentBiz;
import com.yc.dao.BaseDao;

@Service
public class StudentBizImpl implements StudentBiz{

	private BaseDao baseDao;
	
	public Student add(Student student) {
		 this.baseDao.add(student, "insertstudent");
		 return student;
	}

	
	@Resource(name="baseDaoMyBatisImpl")
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
}
