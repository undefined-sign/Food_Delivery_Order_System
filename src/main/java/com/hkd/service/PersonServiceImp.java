package com.hkd.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hkd.mapper.PersonMapper;
import com.hkd.pojo.Person;

@Service
public class PersonServiceImp implements PersonService {

	@Autowired
	PersonMapper personMapper;
	
	@Override
	public void addPerson(Person person) {
		// TODO Auto-generated method stub

		personMapper.insertPerson(person);
	}

	@Override
	public Person login(int id, String pwd, String status) {
		// TODO Auto-generated method stub
		return personMapper.Login(id, pwd, status);
	}

}
