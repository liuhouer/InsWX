package com.inspinia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inspinia.dao.MemberMapper;
import com.inspinia.entity.Member;

@Service
public class MemberService{
	

	@Autowired
	private MemberMapper memberMapper;
	
	
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return memberMapper.deleteByPrimaryKey(id);
	}

	
	public int insert(Member record) {
		// TODO Auto-generated method stub
		return memberMapper.insert(record);
	}

	
	public Member selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return memberMapper.selectByPrimaryKey(id);
	}

	
	public List<Member> selectAll() {
		// TODO Auto-generated method stub
		return memberMapper.selectAll();
	}

	
	public int updateByPrimaryKey(Member record) {
		// TODO Auto-generated method stub
		return memberMapper.updateByPrimaryKey(record);
	}


}
