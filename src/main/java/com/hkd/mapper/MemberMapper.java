package com.hkd.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.hkd.pojo.Member;

public interface MemberMapper {

	//查询所有信息
	public ArrayList<Member> selectAllMembers();


	//根据卡号查
	public Member  getMemberByid(int mid);


	//注册会员

	public void  insertMember(String tel);

	//更新积分

	public void  updatePoints(@Param("id") int id,@Param("point") double point);

}
