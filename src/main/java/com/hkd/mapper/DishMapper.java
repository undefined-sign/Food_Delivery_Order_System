package com.hkd.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.hkd.pojo.Dish;

public interface DishMapper {
	
	//所有信息
	public ArrayList<Dish> selectAllDishes();

	//根据category
	public ArrayList<Dish> getDishesByCId(int cid);

	//根据dish_id
	public Dish getDishByid(int id);

	//数据插入
	public void insertDish(Dish dish) ;

	//修改

	public void updateDish(Dish dish);

	//模糊查询

	public ArrayList<Dish> getDishesBypage(@Param("pname") String pname,@Param("offset")int offset);

	//统计模糊查询数目

	public int count(String pname);

}
