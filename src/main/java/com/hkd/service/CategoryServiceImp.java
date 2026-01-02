package com.hkd.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hkd.mapper.CategoryMapper;
import com.hkd.pojo.Category;

@Service
public class CategoryServiceImp implements CategoryService {
	
	@Autowired
	CategoryMapper cm;

	@Override
	public ArrayList<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return cm.selectAllCategories();
	}


	
	

}
