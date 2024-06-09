package com.ajax.model;

public class Product 
{
	private int pid;
	private String pname;
	private String pdesc;
	private String pcatagory;
	
	public Product() {}
	
	public Product(String pname, String pdesc, String pcatagory) {
		super();
		this.pname = pname;
		this.pdesc = pdesc;
		this.pcatagory = pcatagory;
	}
	public Product(int pid, String pname, String pdesc, String pcatagory) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pdesc = pdesc;
		this.pcatagory = pcatagory;
	}
	
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public String getPcatagory() {
		return pcatagory;
	}
	public void setPcatagory(String pcatagory) {
		this.pcatagory = pcatagory;
	}
	
	
}
