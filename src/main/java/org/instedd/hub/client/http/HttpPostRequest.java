package org.instedd.hub.client.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.instedd.hub.client.constants.Constant;
import org.instedd.hub.client.http.response.ResponseStatus;
import org.instedd.hub.client.http.response.parser.JsonParser;
import org.instedd.hub.client.http.utils.EncodingUtils;
import org.json.JSONObject;

/**
 * @author Kakada Chheang
 *
 */
public class HttpPostRequest extends AbstractHttpRequest {
	
	private HttpPost request;
	
	public HttpPostRequest(URI uri){
		request = new HttpPost(uri);
	}

	public ResponseStatus send() throws IOException {
		
		ResponseStatus status = null;
		
		HttpClient client = HttpClientBuilder.create().build();
		
		request.setEntity(new UrlEncodedFormEntity(this.getFormData().getParams()));
		
		HttpResponse response = client.execute(request);
 
		BufferedReader bufferReader = new BufferedReader(
                       new InputStreamReader(response.getEntity().getContent()));
 
		if (response.getStatusLine().getStatusCode() == HttpURLConnection.HTTP_OK) {
			JSONObject json = JsonParser.parse(bufferReader);
			status = new ResponseStatus(json.getBoolean(ResponseStatus.AVAILABLE), json.getString(ResponseStatus.MESSAGE));
		} else {
			status = new ResponseStatus(false, response.getStatusLine().getReasonPhrase());
		}
		
		return status;
	}
	
	/**
	 * Set basic authentication to request header
	 * @param username
	 * @param password
	 */
	public void setBasicAuthentication(String username, String password) {
		request.setHeader(Constant.HEADER_AUTHORIZATION, EncodingUtils.getBasicAuthString(username, password));
	}
	
}
