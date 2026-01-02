package com.hkd.service;

import com.hkd.pojo.Person;

public interface PersonService {
	
	//注册操作
	public void addPerson(Person person);
    
	//登陆操作
	public Person login(int id, String pwd, String status);
}

