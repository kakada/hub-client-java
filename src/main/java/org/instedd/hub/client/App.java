package org.instedd.hub.client;

import java.net.URI;
import java.net.URISyntaxException;

import org.instedd.hub.client.constants.Constant;
import org.instedd.hub.client.form.FormData;
import org.instedd.hub.client.service.HubClientServiceImpl;
import org.instedd.hub.client.service.IHubClientService;
import org.json.JSONObject;

/**
 * @author Kakada Chheang
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	try {
			URI uri = new URI("http://localhost:3000/" + Constant.PING_URL);
    		String username = "";
    		String password = "";
    		
    		// GET request
    		IHubClientService hubClientService = new HubClientServiceImpl(username, password);
    		JSONObject json = hubClientService.doGet(uri);
			
			System.out.println(json.toString());
			
			// POST request
			uri = new URI("http://localhost:3000/" + Constant.FORM_SUBMIT_URL);
			FormData formData = new FormData();
			formData.addParam("params1", "test");
			
			json = hubClientService.doPost(uri, formData);
			
			System.out.println(json.toString());
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}
        
    }
}
