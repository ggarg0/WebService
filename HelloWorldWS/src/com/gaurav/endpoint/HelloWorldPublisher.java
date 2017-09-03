package com.gaurav.endpoint;

import javax.xml.ws.Endpoint;
import com.gaurav.ws.HelloWorldImpl;

public class HelloWorldPublisher {

	public static void main(String[] args) {
		
			   Endpoint.publish("http://localhost:9999/ws/hello",
					   new HelloWorldImpl());
	
	}
}
