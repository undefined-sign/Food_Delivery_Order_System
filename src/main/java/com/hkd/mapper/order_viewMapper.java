package com.hkd.mapper;

import java.time.LocalDate;
import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.hkd.pojo.order_view;

public interface order_viewMapper {

	//查询所有订单
	public ArrayList<order_view> selectAllOrders();
	//查询待处理订单
	public ArrayList<order_view> selectOrders();
	//按照日期查询
	public ArrayList<order_view>  selectOrdersByDate(LocalDate date);
	//按日期分组查询
	public ArrayList<order_view>  selectOrdersByTime();
	//按菜品分组查询
	public ArrayList<order_view>  selectOrdersByDish();
	//按订单号查询
	public ArrayList<order_view>  selectOrdersByOid(@Param("uid") int uid,@Param("order_id") int order_id);
	//按员工编号查询
	public ArrayList<order_view>  selectOrdersByUid2(int uid);
}
