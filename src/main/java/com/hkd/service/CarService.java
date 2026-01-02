package com.hkd.service;

import java.util.ArrayList;

import com.hkd.pojo.Car;

public interface CarService {

	// 按dish_id进行查询
	public Car getCarByid(int id);

	//添加购物车
	public void addCar(int id,ArrayList<Car> clist);

	//删除购物车
	public void removeCar(int id,ArrayList<Car> clist);

	//修改购物车
	public void updateCar(Car car,ArrayList<Car> clist);
}
