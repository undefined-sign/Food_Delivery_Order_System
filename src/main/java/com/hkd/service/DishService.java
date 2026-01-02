package com.hkd.service;

import java.util.ArrayList;

import com.hkd.pojo.Dish;

public interface DishService {

		//所有信息
		public ArrayList<Dish>  getAllDishes();

		//根据category
		public ArrayList<Dish> getDishesByCid(int cid);

		//根据dish_id
		public Dish getDishByid(int id);

		//数据插入
		public void addDish(Dish dish) ;

		//修改

		public void updateDish(Dish dish);

		//模糊查询

		public ArrayList<Dish> getDishesBypage(String pname,int pageno);

		//统计模糊查询数目

		public int count(String pname);
	
}
