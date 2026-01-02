package com.hkd.mapper;

import org.apache.ibatis.annotations.Param;

import com.hkd.pojo.Person;

public interface PersonMapper {
    
	//注册操作
	public void insertPerson(Person person) ;

    //登陆操作
	public Person Login(@Param("id")int id,@Param("pwd") String pwd,@Param("status")String status);
}
