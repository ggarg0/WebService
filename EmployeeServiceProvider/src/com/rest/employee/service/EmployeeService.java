package com.rest.employee.service;

import java.net.URISyntaxException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rest.employee.model.Employee;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/emp")
public class EmployeeService {

	@Path("/get/{empID}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Employee getEmployee(@PathParam("empID") int empID) {
		Employee emp = new Employee();
		emp.setEmployeeId(empID);
		emp.setEmployeeName("Gaurav Garg");
		emp.setEmployeeMail("gaurav.garg@pepsico.com");

		return emp;

	}

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Employee createEmployee(Employee emp) {
		emp.setEmployeeName(emp.getEmployeeName() + " Created");
		return emp;

	}
	
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Employee updateEmployee(Employee emp) {
		emp.setEmployeeMail("gaurav_garg11@infosys.com");
		return emp;

	}
	
	@DELETE
	@Path("/delete/{empID}")
	public Response deleteEmployee(@PathParam("empID") int empID) 
			throws URISyntaxException{
		return Response.status(200).entity("Employee with " + empID 
				+ " is deleted successfully").build();
	}
	
	

}
