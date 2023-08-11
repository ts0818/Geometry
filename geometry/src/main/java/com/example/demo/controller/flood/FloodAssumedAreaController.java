package com.example.demo.controller.flood;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.flood.FloodGeoJsonDto;
import com.example.demo.entity.flood.FloodAssumedAreaShizuoka;
import com.example.demo.service.impl.flood.FloodAssumedAreaShizuokaServiceImpl;

@RestController
@RequestMapping("floodAssumedArea")
public class FloodAssumedAreaController {

	@Autowired
	FloodAssumedAreaShizuokaServiceImpl floodAssumedAreaShizuokaServiceImpl;
	
	@GetMapping(value="/shizuoka")
	public List<FloodAssumedAreaShizuoka> serachFloodForShizuoka() {
		List<FloodAssumedAreaShizuoka> floodAssumedAreaShizuoka = floodAssumedAreaShizuokaServiceImpl.findAll();
		return floodAssumedAreaShizuoka;
	}
	
	@GetMapping(value="/shizuoka/{gid}")
	public FloodAssumedAreaShizuoka searchbyIdForShizuoka(@PathVariable("gid") Long gid) {
		FloodAssumedAreaShizuoka  floodAssumedAreaShizuoka  = floodAssumedAreaShizuokaServiceImpl.findById(gid);
		return floodAssumedAreaShizuoka;
	}
	
	@PostMapping(value="/shizuoka/save", consumes = "application/json")
	public int saveForShizuoka(@RequestBody FloodGeoJsonDto floodGeoJsonDto) {
		FloodAssumedAreaShizuoka  floodAssumedAreaShizuoka = floodAssumedAreaShizuokaServiceImpl.createSaveData(floodGeoJsonDto);
		int result = 0;
		if (Objects.nonNull(floodAssumedAreaShizuoka)) {
			result = floodAssumedAreaShizuokaServiceImpl.insert(floodAssumedAreaShizuoka);
		}
		return result;
	}	
}
