package com.hkd.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hkd.mapper.order_viewMapper;
import com.hkd.pojo.order_view;

@Service
public class order_viewServiceImp implements order_viewService {

	@Autowired
	private order_viewMapper ovm;

	@Override
	public ArrayList<order_view> getAllOrders() {
		// TODO Auto-generated method stub
	
		return ovm.selectAllOrders();
	}

	@Override
	public ArrayList<order_view> getOrders() {
		// TODO Auto-generated method stub

		
		return ovm.selectOrders();
	}

	@Override
	public ArrayList<order_view> getOrdersByTime() {
		// TODO Auto-generated method stub

		return ovm.selectOrdersByTime();
	}

	@Override
	public ArrayList<order_view> getOrdersByDish() {
		// TODO Auto-generated method stub

		return ovm.selectOrdersByDish();
	}

	@Override
	public ArrayList<order_view> getOrdersByOid(int uid, int order_id) {
		// TODO Auto-generated method stub
	
		return ovm.selectOrdersByOid(uid, order_id);
	}

	@Override
	public ArrayList<order_view> getOrdersByUid(int uid) {
		// TODO Auto-generated method stub
		return ovm.selectOrdersByUid2(uid);
	}

}
