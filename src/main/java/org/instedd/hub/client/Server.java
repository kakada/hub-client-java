package org.instedd.hub.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Kakada Chheang
 *
 */

public class Server {
	
	private static final String PING_PATH = "api/system/ping";
	private static final String HEADER_AUTHORIZATION = "Authorization";
	
	private String url;
	private String username;
	private String password;
	
	private HttpURLConnection connection;
	
	public Server(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}
	
	public void connect() {
		try {
			URL url = new URL(this.url);

			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setDoOutput(true);
			connection.setRequestProperty(HEADER_AUTHORIZATION, CodecUtils.getBasicAuthString(username, password));
			connection.connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean isAvailable() throws IOException {
		return (getResponseCode() == HttpURLConnection.HTTP_OK);
	}
	
	public int getResponseCode() throws IOException {
		return connection.getResponseCode();
	}
	
	public String getResponseText() throws IOException {
		String responseText = "";
		if (isAvailable()) {
			InputStream content = (InputStream) connection.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(content));
			String line;
			while ((line = in.readLine()) != null) {
				responseText += line;
			}
		} else {
			responseText = connection.getResponseMessage();
		}
		
		return responseText;
	}

}
