package com.yc.bizImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.bean.Person;
import com.yc.biz.PersonBiz;
import com.yc.dao.BaseDao;

@Service
public class PersonBizImpl implements PersonBiz{
	private BaseDao<Person> baseDao;
	
	

	public BaseDao<Person> getBaseDao() {
		return baseDao;
	}


	@Resource(name="baseDaoMyBatisImpl")
	public void setBaseDao(BaseDao<Person> baseDao) {
		this.baseDao = baseDao;
	}



	@Override
	public List<Person> findAll() {
		Person p=new Person();
		return this.baseDao.findAll(p, "findAll");
	}
	
	
}
