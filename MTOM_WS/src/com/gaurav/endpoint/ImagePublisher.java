package com.gaurav.endpoint;

import javax.xml.ws.Endpoint;
import com.gaurav.ws.ImageServerImpl;

//Endpoint publisher
public class ImagePublisher{
	
	public static void main(String[] args) {
		
		Endpoint.publish("http://localhost:7001/ws/image", new ImageServerImpl());
		
		System.out.println("Server is published!");
	   
    }

}
