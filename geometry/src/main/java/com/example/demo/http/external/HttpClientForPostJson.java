package com.example.demo.http.external;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
//@RequiredArgsConstructor
public class HttpClientForPostJson extends HttpClientBase {
	
	public HttpResponse<?> postJson(String requestUrl) throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder(URI.create(requestUrl))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(
                        new ObjectMapper()
                          .writeValueAsString(Map.of("key", "value"))
                          )
                )
                .build();
        HttpResponse<String> httpResponse = super.httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        return httpResponse;
	}
}
