package com.hkd.pojo;
import java.time.LocalDate;

public class order_view {
	
	private int uid;
	private String uname;
	private int order_id;
	private String category;
	private String address;
	private int dish_id;
	private String dish_name;
	private double price;
	private int num;
	private LocalDate time;
	private double sum;
	private String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getDish_id() {
		return dish_id;
	}
	public void setDish_id(int dish_id) {
		this.dish_id = dish_id;
	}
	public String getDish_name() {
		return dish_name;
	}
	public void setDish_name(String dish_name) {
		this.dish_name = dish_name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public LocalDate getTime() {
		return time;
	}
	public void setTime(LocalDate time) {
		this.time = time;
	}
	
	@Override
	public String toString() {
		return "order_view [uid=" + uid + ", uname=" + uname + ", order_id=" + order_id + ", category=" + category
				+ ", address=" + address + ", dish_id=" + dish_id + ", dish_name=" + dish_name + ", price=" + price
				+ ", num=" + num + ", time=" + time + "]"+status;
	}
	
	
	
	

}
