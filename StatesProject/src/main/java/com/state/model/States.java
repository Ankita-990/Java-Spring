package com.state.model;


public class States 
{
	private int sid;
	private String sname;
	
	public States() {}
	
	public States(String sname) {
		this.sname = sname;
	}
	
	public States(int sid, String sname) {
		this.sid = sid;
		this.sname = sname;
	}
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}	
}
