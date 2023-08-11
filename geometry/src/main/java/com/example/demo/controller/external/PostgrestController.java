package com.example.demo.controller.external;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.constants.external.PostgrestConstant;
import com.example.demo.service.impl.external.ExternalHttpRequestImpl;

@RestController
@RequestMapping("postgrest")
public class PostgrestController {

	@Autowired
	ExternalHttpRequestImpl externalHttpRequestImpl;
	
	@GetMapping(value="/getByParam/{tableName}")
	public String getJsonByRequestParam(
			@PathVariable(name="tableName", required=false) String tableName
			, @RequestParam(name="gid", required=false) String gid) throws IOException, InterruptedException {
		Map<String, Object> requestParams = Map.of(
				"gid", gid
		);
		String postgrestBaseUrl = PostgrestConstant.baseUrlForDbOfSample + "/" + tableName;
		String responseBody = externalHttpRequestImpl.getJson(postgrestBaseUrl, requestParams);
		return responseBody;
	}
	
}
