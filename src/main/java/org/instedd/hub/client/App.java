package org.instedd.hub.client;

import org.instedd.hub.client.service.impl.HubClientServiceImpl;

/**
 * @author Kakada Chheang
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        HubClientServiceImpl hubClientService = new HubClientServiceImpl();
        AvailabilityStatus status = hubClientService.ping("http://localhost:3002/api/ping", "test", "secret");
        if (status != null) System.out.println(status.toString());
    }
}
