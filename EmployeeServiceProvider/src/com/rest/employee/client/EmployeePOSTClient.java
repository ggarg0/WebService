package com.rest.employee.client;

import com.rest.employee.model.Employee;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class EmployeePOSTClient {

	public static void main(String[] args) {
		Client client = Client.create();
		WebResource webResource=client.resource
				("http://localhost:7001/EmployeeServiceProvider/rest/emp/create");
		
		Employee emp = new Employee();
		emp.setEmployeeId(1001);
		emp.setEmployeeName("Gurav Garg");
		emp.setEmployeeMail("gauravgarg.gg25@gmail.com");
		
		ClientResponse response = 
				webResource.type("application/xml").post(ClientResponse.class,emp);
		System.out.println("Create operation response processing... ");
		Employee output=response.getEntity(Employee.class);
		System.out.println("Emp Id : "+ output.getEmployeeId());
		System.out.println("Output : "+ output.getEmployeeName());
		System.out.println("Output : "+ output.getEmployeeMail());

	}

}
