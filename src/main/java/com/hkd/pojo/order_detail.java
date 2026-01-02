package com.hkd.pojo;
public class order_detail {
	
	private int order_id;
	private int dish_id;
	private int num;
	private double price;
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int ordr_id) {
		this.order_id = ordr_id;
	}
	public int getDish_id() {
		return dish_id;
	}
	public void setDish_id(int dish_id) {
		this.dish_id = dish_id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}
