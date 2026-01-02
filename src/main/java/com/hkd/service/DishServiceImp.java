package com.hkd.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hkd.mapper.DishMapper;
import com.hkd.pojo.Dish;

@Service
public class DishServiceImp implements DishService {

	@Autowired
	DishMapper dm;	

	@Override
	public ArrayList<Dish> getAllDishes() {
		// TODO Auto-generated method stub
		return dm.selectAllDishes();
	}

	@Override
	public ArrayList<Dish> getDishesByCid(int cid) {
		// TODO Auto-generated method stub
		return dm.getDishesByCId(cid);
	}

	@Override
	public Dish getDishByid(int id) {
		// TODO Auto-generated method stub
		return dm.getDishByid(id);
	}

	@Override
	public void addDish(Dish dish) {
		// TODO Auto-generated method stub
		dm.insertDish(dish);
	}

	@Override
	public void updateDish(Dish dish) {
		// TODO Auto-generated method stub
		dm.updateDish(dish);
	}

	@Override
	public ArrayList<Dish> getDishesBypage(String pname, int pageno) {
		// TODO Auto-generated method stub
		return dm.getDishesBypage(pname, pageno);
	}

	@Override
	public int count(String pname) {
		// TODO Auto-generated method stub
		return dm.count(pname);
	}
	
	
	
}
