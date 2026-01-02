package com.hkd.pojo;
public class Dish {
	
	
	private int dish_id;
	private String dish_name;
	private double price;
	private int category_id;
	private int quantity;
	
	

	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	@Override
	public String toString() {
		return "Dish [dish_id=" + dish_id + ", dish_name=" + dish_name + ", price=" + price + ", category_id="
				+ category_id + ", quantity=" + quantity + "]";
	}

}
