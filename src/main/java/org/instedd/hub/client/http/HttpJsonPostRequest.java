package org.instedd.hub.client.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.instedd.hub.client.constants.Constant;
import org.instedd.hub.client.http.response.parser.JsonParser;
import org.instedd.hub.client.http.utils.EncodingUtils;
import org.json.JSONObject;

/**
 * @author Kakada Chheang
 *
 */
public class HttpJsonPostRequest extends AbstractHttpJsonRequest {
	
	private HttpPost request;
	
	public HttpJsonPostRequest(URI uri){
		request = new HttpPost(uri);
	}

	public JSONObject send() throws IOException {
		
		JSONObject json = new JSONObject();
		
		HttpClient client = HttpClientBuilder.create().build();
		
		request.setEntity(new StringEntity(this.getFormData().getParamsAsJson().toString()));
		
		HttpResponse response = client.execute(request);
 
		BufferedReader bufferReader = new BufferedReader(
                       new InputStreamReader(response.getEntity().getContent()));
 
		if (response.getStatusLine().getStatusCode() == HttpURLConnection.HTTP_OK) {
			json = JsonParser.parse(bufferReader);
		} else {
			json.put(Constant.RESPONSE_STATUS, "FAILED");
			json.put(Constant.RESPONSE_MESSAGE, "Something went wrong");
		}
		
		return json;
	}
	
	public void setBasicAuthentication(String username, String password) {
		request.setHeader(Constant.HEADER_AUTHORIZATION, EncodingUtils.getBasicAuthString(username, password));
	}
	
	public void setDefaultHeaders() {
		request.setHeaders(getDefaultHeaders());
	}
	
}
