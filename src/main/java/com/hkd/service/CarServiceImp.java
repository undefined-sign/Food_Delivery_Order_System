package com.hkd.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hkd.pojo.Car;
import com.hkd.pojo.Category;
import com.hkd.pojo.Dish;

@Service
public class CarServiceImp implements CarService {

	@Autowired
	private DishService dsi;

	@Override
	public Car getCarByid(int id) {
		// TODO Auto-generated method stub

		//获取Dish对象
		Dish dish=dsi.getDishByid(id);
		

		//产生购物车对象

		Car car=new Car();

		car.setDish_id(id);
		car.setDish_name(dish.getDish_name());
		car.setNum(1);
		car.setPrice(dish.getPrice());
		car.setQuantity(dish.getQuantity());



		return car;
	}

	@Override
	public void addCar(int id, ArrayList<Car> clist) {
		// TODO Auto-generated method stub

		//根据id产生car对象
		Car car=this.getCarByid(id);
		boolean flag=false;

		//遍历clist
		for (Car c : clist) {
			if(c.getDish_id()==id) {
				flag=true;
				c.setNum(c.getNum()+1);
				break;
			}
		}

		if(!flag) {

			clist.add(car);
		}

	}

	@Override
	public void removeCar(int id, ArrayList<Car> clist) {
		// TODO Auto-generated method stub

		//遍历clist
		for(int i=0;i<clist.size();i++) {

			if(clist.get(i).getDish_id()==id) {
				clist.remove(i);
				break;
			}
		}

	}

	@Override
	public void updateCar(Car car, ArrayList<Car> clist) {
		// TODO Auto-generated method stub

		//遍历clist
		for (Car element : clist) {

			if(element.getDish_id()==car.getDish_id()) {
				element.setNum(car.getNum());
				break;
			}
		}

	}

}
