package com.hkd.mapper;

import org.apache.ibatis.annotations.Param;

import com.hkd.pojo.order_detail;

public interface order_detailMapper {

	//插入操作
	public void insertod(order_detail od);

	//删除操作
	public void del(@Param("order_id") int order_id,@Param("dish_id")int dish_id);
	
}
