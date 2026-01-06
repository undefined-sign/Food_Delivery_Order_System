package com.hkd.service;

import java.time.LocalDate;
import java.util.ArrayList;

import com.hkd.pojo.order_view;

public interface order_viewService {

	//查询所有订单
	public ArrayList<order_view> getAllOrders();
	//查询未处理订单
	public ArrayList<order_view> getOrders();
	//按日期查询
	public ArrayList<order_view> getOrdersByDate(LocalDate date);
	//按日期分组查询
	public ArrayList<order_view>  getOrdersByTime();
	//按菜品分组查询
	public ArrayList<order_view>  getOrdersByDish();
	//按订单号查询
	public ArrayList<order_view>  getOrdersByOid(int uid,int order_id);
	//按员工编号查询
	public ArrayList<order_view>  getOrdersByUid(int uid);
}
