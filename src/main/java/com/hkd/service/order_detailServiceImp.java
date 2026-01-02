package com.hkd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hkd.mapper.order_detailMapper;
import com.hkd.pojo.order_detail;

@Service
public class order_detailServiceImp implements order_detailService {

	@Autowired
	private order_detailMapper oddm;

	@Override
	public void addod(order_detail od) {
		// TODO Auto-generated method stub

		oddm.insertod(od);

	}

	@Override
	public void remove(int order_id, int dish_id) {
		// TODO Auto-generated method stub
		oddm.del(order_id, dish_id);
	}



}
