package com.hkd.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hkd.mapper.MemberMapper;
import com.hkd.pojo.Member;

@Service
public class MemberServiceImp implements MemberService {

	@Autowired
	private MemberMapper mm;

	@Override
	public Member getMemberByid(int mid) {
		// TODO Auto-generated method stub
		return mm.getMemberByid(mid);
	}

	@Override
	public void addMember(String tel) {
		// TODO Auto-generated method stub

		mm.insertMember(tel);


	}

	@Override
	public ArrayList<Member> getAllMembers() {
		// TODO Auto-generated method stub
		return mm.selectAllMembers();
	}

	@Override
	public void updatePoints(int id, double point) {
		// TODO Auto-generated method stub
		mm.updatePoints(id, point);
	}

}
