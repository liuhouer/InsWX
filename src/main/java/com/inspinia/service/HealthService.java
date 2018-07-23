package com.inspinia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inspinia.dao.HealthMapper;
import com.inspinia.entity.Health;

@Service
public class HealthService{
	

	@Autowired
	private HealthMapper healthMapper;
	
	
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return healthMapper.deleteByPrimaryKey(id);
	}

	
	public int insert(Health record) {
		// TODO Auto-generated method stub
		return healthMapper.insert(record);
	}

	
	public Health selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return healthMapper.selectByPrimaryKey(id);
	}

	
	public List<Health> selectAll() {
		// TODO Auto-generated method stub
		return healthMapper.selectAll();
	}

	
	public int updateByPrimaryKey(Health record) {
		// TODO Auto-generated method stub
		return healthMapper.updateByPrimaryKey(record);
	}


}
