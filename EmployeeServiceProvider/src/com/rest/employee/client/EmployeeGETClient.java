package com.rest.employee.client;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import com.rest.employee.model.Employee;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class EmployeeGETClient {
	
	public static void main(String[] args)
	{
		Client client = Client.create();
		WebResource webResource=client.resource
				("http://localhost:7001/EmployeeServiceProvider/rest/emp/get/100");
		ClientResponse response = 
				webResource.type("application/xml").get(ClientResponse.class);
	
		System.out.println("Get operation response processing... ");
		Employee output=response.getEntity(Employee.class);
		System.out.println("Output : "+ output.getEmployeeName());
		
	}
}

