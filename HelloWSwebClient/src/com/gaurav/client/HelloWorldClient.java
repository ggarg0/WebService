package com.gaurav.client;


import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;

import com.gaurav.ws.HelloWorld;

public class HelloWorldClient {
	public static void main(String[] args) throws Exception {

		URL url = new URL("http://192.168.1.64:7001/HelloWorldWS/HelloWorldImplService?WSDL");

		//1st argument service URI, refer to wsdl document above
		//2nd argument is service name, refer to wsdl document above
		QName qname = new QName("http://ws.gaurav.com/", "HelloWorldImplService");

		Service service = Service.create(url, qname);

		HelloWorld hello = service.getPort(HelloWorld.class);

		
		BindingProvider prov = (BindingProvider)hello;
		prov.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "user");
		prov.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "pass1234");

	
		
		//Application Security
		Map<String, Object> requestContext = ((BindingProvider)hello).getRequestContext();

		requestContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://192.168.1.64:7001/HelloWorldWS/HelloWorldImplService?WSDL");

		Map<String, List<String>> requestHeaders = new HashMap<String, List<String>>();

		requestHeaders.put("username", Collections.singletonList("user"));
		requestHeaders.put("Password", Collections.singletonList("pass1234"));

		requestContext.put(MessageContext.HTTP_REQUEST_HEADERS, requestHeaders);
		 
		
		System.out.println(hello.getHelloWorldAsString("JAVA"));

	}

}


