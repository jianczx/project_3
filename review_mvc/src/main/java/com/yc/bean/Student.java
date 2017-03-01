package com.yc.bean;

import java.io.Serializable;

public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long sid;
	
	private String sname;

	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid2) {
		this.sid = sid2;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + "]";
	}
	
	

}
