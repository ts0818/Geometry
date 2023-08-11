package com.example.demo.constants.flood;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class FloodConstant {

	@Value("${srid.JGD2011.B.L}")
	public static String srid;
	
	public final static String FLOOD_ASSUMED_AREA_SHIZUOKA = "flood_assumed_area_shizuoka";
	public final static String FLOOD_ASSUMED_AREA_SHIZUOKA_SEQ = "flood_assumed_area_shizuoka_gid_seq";
}
