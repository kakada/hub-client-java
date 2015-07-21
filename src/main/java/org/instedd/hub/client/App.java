package org.instedd.hub.client;

import java.net.URI;
import java.net.URISyntaxException;

import org.instedd.hub.client.constants.Constant;
import org.instedd.hub.client.form.FormData;
import org.instedd.hub.client.http.response.ResponseStatus;
import org.instedd.hub.client.service.HubClientServiceImpl;
import org.instedd.hub.client.service.IHubClientService;

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
    		IHubClientService hubClientService = new HubClientServiceImpl();
    		ResponseStatus status = hubClientService.doGet(uri, username, password);
			
			System.out.println(status.toString());
			
			// POST request
			uri = new URI("http://localhost:30020/api/dhis");
			FormData formData = new FormData();
			formData.addParam("params1", "test");
			
			status = hubClientService.doPost(uri, username, password, formData);
			
			System.out.println(status.toString());
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}
        
    }
}
