package com.hkd.pojo;
import java.time.LocalDateTime;

public class order_header {
	
	private int user_id;
	private int order_id;
	private String address;
	private LocalDateTime order_time;
	private double total_amount;
	private String status;
	
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LocalDateTime getOrder_time() {
		return order_time;
	}
	public void setOrder_time(LocalDateTime order_time) {
		this.order_time = order_time;
	}
	public double getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "order_header [user_id=" + user_id + ", order_id=" + order_id + ", address=" + address + ", order_time="
				+ order_time + ", total_amount=" + total_amount + ", status=" + status + "]";
	}
	
	
}
