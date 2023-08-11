package com.example.demo.http.external;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
public class HttpClientForGetJson extends HttpClientBase {

	public String getJson (String requestUrl, Map<String, Object> requestPrameters ) throws IOException, InterruptedException {
        // リクエストを作成
		String getUrl = createGetRequestUrl(requestUrl, requestPrameters);
        HttpRequest request = HttpRequest.newBuilder(URI.create(getUrl))
                .build();
        // 同期API呼び出し
        HttpResponse<String> response = super.httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
	}
	
	private static String createGetRequestUrl (String requestUrl, Map<String, Object> requestPrameters) {
		
		if (Objects.isNull(requestPrameters) || requestPrameters.size() == 0) {
			return requestUrl;

		} else {
			StringBuilder sb = new StringBuilder();
			sb.append(requestUrl).append("?");
			for (Iterator<Map.Entry<String, Object>> iterator= requestPrameters.entrySet().iterator(); iterator.hasNext();) {
				Map.Entry<String, Object> entry = iterator.next();
				sb
				  .append(entry.getKey())
				  .append("=")
				  .append(entry.getValue());
				if (iterator.hasNext()) {
					sb.append("&");
				}
			}
			return sb.toString();
		}
	}
}
