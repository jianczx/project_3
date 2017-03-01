package com.yc.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	
	/*
	 * 这是控制器中处理请求的方法
	 * req：请求
	 * resp：响应
	 * 返回视图地址
	 * */
	public String HandleRequest(HttpServletRequest request,HttpServletResponse response );
	
}
