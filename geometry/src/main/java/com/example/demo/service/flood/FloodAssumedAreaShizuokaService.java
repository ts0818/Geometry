package com.example.demo.service.flood;

import java.util.List;

import com.example.demo.entity.flood.FloodAssumedAreaShizuoka;

public interface FloodAssumedAreaShizuokaService {
	public List<FloodAssumedAreaShizuoka> findAll();
	
	public FloodAssumedAreaShizuoka findById(Long id);
	
	public int insert(FloodAssumedAreaShizuoka floodAssumedAreaShizuoka);
}
