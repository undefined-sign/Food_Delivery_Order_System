package com.hkd.pojo;

public class Category {
	
	private int cid;
	private String name;
	private String descn;
	
	
	
	public int getCid() {
		return cid;
	}
	public void setCatid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescn() {
		return descn;
	}
	public void setDescn(String descn) {
		this.descn = descn;
	}
	@Override
	public String toString() {
		return "Category [cid=" + cid + ", name=" + name + ", descn=" + descn + "]";
	}
	
	
	
}
