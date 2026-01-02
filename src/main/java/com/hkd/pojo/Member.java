package com.hkd.pojo;

public class Member {
	
	private int number;
	private String level;
	private int points;
	private double discount_rate;
	private String tel;
	
	
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public double getDiscount_rate() {
		return discount_rate;
	}
	public void setDiscount_rate(double discount_rate) {
		this.discount_rate = discount_rate;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "Member [number=" + number + ", level=" + level + ", points=" + points + ", discount_rate="
				+ discount_rate + ", tel=" + tel + "]";
	}

	
	
}
