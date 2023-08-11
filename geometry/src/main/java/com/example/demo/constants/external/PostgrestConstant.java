package com.example.demo.constants.external;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@PropertySource({"classpath:postgrest.properties"})
@Configuration
@Data
public class PostgrestConstant {

	public static String baseUrlForDbOfSample;
	
	public PostgrestConstant (@Value("${base.url.postgrest}") String baseUrlForDbOfSample) {
		PostgrestConstant.baseUrlForDbOfSample = baseUrlForDbOfSample;
	}
}
