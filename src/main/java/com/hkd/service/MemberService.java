package com.hkd.service;

import java.util.ArrayList;

import com.hkd.pojo.Member;

public interface MemberService {

	//查询所有信息
	public ArrayList<Member> getAllMembers();

	//根据卡号查
	public Member  getMemberByid(int mid);


	//注册会员
	public void  addMember(String tel);
	
	//更新积分
	public void  updatePoints(int id,double point);
}
