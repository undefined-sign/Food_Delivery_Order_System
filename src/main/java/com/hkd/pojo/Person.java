package com.hkd.pojo;
public class Person {
	
	private int uid;
	private String uname;
	private String password;
	private String sex;
	private String tel;
	private String status;
	
	
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Person [uid=" + uid + ", uname=" + uname + ", password=" + password + ", sex=" + sex + ", tel=" + tel
				+ ", status=" + status + "]";
	}
	


}
