package com.yc.dao.iml;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.yc.dao.BaseDao;

@Repository
public class BaseDaoMyBatisImpl extends SqlSessionDaoSupport implements BaseDao {
	private String mapperLocation="com.yc.mapper.";
	
	
	private String getMapperId(Object t,String sqlid){
		
		return mapperLocation+t.getClass().getSimpleName()+"Mapper."+sqlid;
	}
	//private SqlSession sqlSession;
	@Resource(name="sqlSessionFactory")
	  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
		  }
	
	@Override
	public List findAll(Object t, String sqlid) {
		return super.getSqlSession().selectList(getMapperId(t,sqlid),t);
	}
	
	@Override
	public List findAll(Object t, Map map, String sqlid) {
		return super.getSqlSession().selectList(getMapperId(t,sqlid),map);
	}
	@Override
	public void add(Object t, String sqlid) {
		 super.getSqlSession().insert(getMapperId(t,sqlid),t);
	}
	@Override
	public void add(Object t, Map map, String sqlid) {
		 super.getSqlSession().insert(getMapperId(t,sqlid),map);
	}
	@Override
	public void addMore(Object t, List list, String sqlid) {
		 super.getSqlSession().insert(getMapperId(t,sqlid),list);
		
	}
	@Override
	public void delete(Object t, String sqlid) {
		 super.getSqlSession().delete(getMapperId(t,sqlid));
	
	}
	@Override
	public void delete(Object t, Map map, String sqlid) {
		 super.getSqlSession().delete(getMapperId(t,sqlid),map);
	}
	@Override
	public void deleteMore(Object t, List list, String sqlid) {
		 super.getSqlSession().delete(getMapperId(t,sqlid),list);
		
	}
	@Override
	public void update(Object t, String sqlid) {
		super.getSqlSession().update(getMapperId(t,sqlid));
	}
	
	@Override
	public void update(Object t, Map map, String sqlid) {
		super.getSqlSession().update(getMapperId(t,sqlid),map);
	}
	@Override
	public void updateMore(Object t, List list, String sqlid) {
		super.getSqlSession().update(getMapperId(t,sqlid),list);
	}
	
	@Override
	public double findFun(Object t, String sqlid) {
		return  super.getSqlSession().selectOne(getMapperId(t,sqlid));
	}
	@Override
	public double findFun(Object t, Map map, String sqlid) {
		return super.getSqlSession().selectOne(getMapperId(t,sqlid),map);
	}

}
