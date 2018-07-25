package com.gaurav.jsontest;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class App {
	public static void main(String[] args) throws IOException {
		Date dt = new Date();
		Customer JsonCustomer = new Customer("1", "Gaurav Garg", dt, "HOME", "NOIDA", "INDIA");
		Employee JsonEmployee = new Employee("2", "RIAAN GARG", "HOME", "NOIDA", "INDIA");
		Employee XMLEmployee = new Employee("3", "NIKITA", "HOME", "NOIDA", "INDIA");

		ObjectMapper JSONMapper = new ObjectMapper();
		ObjectMapper XMLMapper = new XmlMapper();
				
		//Object to JSON in file
		JSONMapper.writeValue(new File("d:\\cust.json"), JsonCustomer);
		JSONMapper.writeValue(new File("d:\\emp.json"), JsonEmployee);
		XMLMapper.writeValue(new File("d:\\emp.xml"), XMLEmployee);
		
		
		//JSON from file to Object
		Customer obj = JSONMapper.readValue(new File("d:\\cust.json"), Customer.class);
		Employee obj2 = JSONMapper.readValue(new File("d:\\emp.json"), Employee.class);		
		Employee obj3 = XMLMapper.readValue(new File("d:\\emp.xml"), Employee.class);
		//JSON from URL to Object
		//Customer obj = mapper.readValue(new URL("http://mkyong.com/api/staff.json"), Customer.class);
		
		System.out.println("Object from JSON :  " + obj.toString());
		System.out.println("Object from JSON :  " + obj2.toString());
		System.out.println("Object from XML :  " + obj3.toString());
	}
}
