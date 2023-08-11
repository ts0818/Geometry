package com.example.demo.config;

import java.net.http.HttpClient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpClientConfig {

	@Bean
	public HttpClient HttpClient () {
		return HttpClient.newHttpClient();
	}
}
