package com.hkd.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.hkd.pojo.order_header;

public interface order_headerMapper {

	//插入操作
	public void insertoh(order_header oh);


	//按用户号查询
	public ArrayList<order_header>  selectOrdersByUid(int uid);
	
	//修改订单状态
	public void updateStatus(@Param("order_id") int order_id, @Param("status") String status);
	
}
