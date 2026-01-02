package com.hkd.service;

import com.hkd.pojo.order_detail;

public interface order_detailService {
	
	//插入操作
	public void addod(order_detail od);

	//删除操作
	public void remove(int order_id,int dish_id);

}
