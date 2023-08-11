package com.example.demo.http.external;

import java.net.http.HttpClient;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public abstract class HttpClientBase {

	@Autowired
	protected HttpClient httpClient;

}
