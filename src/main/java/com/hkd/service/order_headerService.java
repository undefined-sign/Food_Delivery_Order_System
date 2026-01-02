package com.hkd.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.hkd.pojo.order_header;

public interface order_headerService {
	
	//插入操作
	public void addoh(order_header oh);


	//按员工号查询
	public ArrayList<order_header>  getOrdersByUid(int uid);
	
	
	//修改订单状态
	public void updateStatus(int order_id,String status);
}
