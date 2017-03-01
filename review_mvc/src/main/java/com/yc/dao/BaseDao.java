package com.yc.dao;

import java.util.List;
import java.util.Map;


public interface BaseDao<T> {
	public List<T> findAll(T t,String sqlid);
	
	public List<T> findAll(T t,Map map,String sqlid);
	//add delete update
	
	public void add(T t,String sqlid);
	
	public void add(T t,Map map,String sqlid);
	
	public void addMore(T t,List list,String sqlid);
	
	public void delete(T t,String sqlid);
	
	public void delete(T t,Map map,String sqlid);
	
	//????????????
	public void deleteMore(T t,List list,String sqlid);
	
	public void update(T t,String sqlid);
	
	public void update(T t,Map map,String sqlid);
	
	public void updateMore(T t,List list,String sqlid);
	
	//??????
	
	public double findFun(T t,String sqlid);
	
	public double findFun(T t,Map map,String sqlid);

	
}
