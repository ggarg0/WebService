package com.soap.webservice.clients;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.soap.webservice.beans.Person;
import com.soap.webservice.service.PersonService;


public class Client {

	public static void main(String[] args) throws MalformedURLException {
	
		URL wsdlURL = new URL("http://localhost:8080/SOAPWebServiceExample/personWS?wsdl");
		//check above URL in browser, you should see WSDL file
		
		//creating QName using targetNamespace and name
		QName qname = new QName("http://service.webservice.soap.com/", "PersonServiceImplService"); 
		
		Service service = Service.create(wsdlURL, qname);  
		
		//We need to pass interface and model beans to client
		PersonService ps = service.getPort(PersonService.class);
		
		Person p1 = new Person();
		p1.setName("Pankaj");
		p1.setId(1);
		p1.setAge(65);
		
		Person p2 = new Person();
		p2.setName("Pranjal");
		p2.setId(2);
		p2.setAge(45);
	
		Person p3 = new Person();
		p3.setName("Prem");
		p3.setId(3);
		p3.setAge(25);
	
		Person p4 = new Person();
		p4.setName("Prakash");
		p4.setId(4);
		p4.setAge(35);
	

		
		//add person
		System.out.println("Adding Person : ");
		System.out.println("---------------");
		System.out.println("Add Person Status="+ps.addPerson(p1));
		System.out.println("Add Person Status="+ps.addPerson(p2));
		System.out.println("Add Person Status="+ps.addPerson(p3));
		System.out.println("Add Person Status="+ps.addPerson(p4));
		System.out.println();
		
		//get all persons
		System.out.println("Get All Persons : ");
		System.out.println("------------------");
		System.out.println(Arrays.asList(ps.getAllPersons()));		
		System.out.println();
		
		//get person
		System.out.println("Get One Person : ");
		System.out.println("-----------------");
		System.out.println(ps.getPerson(1));
		System.out.println();	
		
		//delete person
		System.out.println("Delete Person : " + ps.getPerson(2).getName());
		System.out.println("----------------------");
		System.out.println("Delete Person Status="+ps.deletePerson(2));
		System.out.println();
		
		//get all persons
		System.out.println("Get All Persons : ");
		System.out.println("------------------");
		System.out.println(Arrays.asList(ps.getAllPersons()));
		System.out.println();
	}
}