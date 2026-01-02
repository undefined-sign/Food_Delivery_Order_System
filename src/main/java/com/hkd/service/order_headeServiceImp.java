package com.hkd.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hkd.mapper.order_headerMapper;
import com.hkd.pojo.order_header;

@Service
public class order_headeServiceImp implements order_headerService {

	@Autowired
	private order_headerMapper odm;

	@Override
	public void addoh(order_header oh) {
		// TODO Auto-generated method stub

		odm.insertoh(oh);
	}



	@Override
	public ArrayList<order_header> getOrdersByUid(int uid) {
		// TODO Auto-generated method stub
		
		return odm.selectOrdersByUid(uid);
	}



	@Override
	public void updateStatus(int order_id, String status) {
		// TODO Auto-generated method stub
		odm.updateStatus(order_id, status);
	}

}
