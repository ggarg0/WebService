package com.RestWS.params;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;

import sun.misc.BASE64Encoder;

public class JersyClient {

	public static void main(String[] args) {
		String url = "http://localhost:8080/RestWithJersey/api/users/httpheader/get";
        String name = "gaurav";
        String password = "Garg!";
        String authString = name + ":" + password;
        System.out.println("authString: " + authString);
        String authStringEnc = new BASE64Encoder().encode(authString.getBytes());
        System.out.println("Base64 encoded auth string: " + authStringEnc);
        Client restClient = Client.create();
        com.sun.jersey.api.client.WebResource webResource = restClient.resource(url);
        ClientResponse resp = webResource.accept("application/json")
                                         .header("Authorization", "Basic " + authStringEnc)
                                         .get(ClientResponse.class);
        if(resp.getStatus() != 200){
            System.err.println("Unable to connect to the server");
        }
        String output = resp.getEntity(String.class);
        System.out.println("response: "+output);

	}

}
