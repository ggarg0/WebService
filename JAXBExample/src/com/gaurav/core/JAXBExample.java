package com.gaurav.core;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Marshaller;

 
public class JAXBExample {
	public static void main(String[] args) {
		
		
		//createMarshaller
		 Customer customer = new Customer();
		  customer.setId(101);
		  customer.setName("gaurav");
		  customer.setAge(27);
	 
		  try {
			System.out.println("Creating file.xml in b drive");
			File file = new File("b:\\JAXBfile.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
			System.out.println("Creating Marshaller");
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	 
			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	 
			jaxbMarshaller.marshal(customer, file);
			//jaxbMarshaller.marshal(customer, System.out);
			System.out.println("file.xml created in b drive and Marshaller task completed");
		      } catch (JAXBException e) {
			e.printStackTrace();
		      }

		//createUnmarshaller
		
 
	 try {
		 System.out.println();
		
		System.out.println("Reading file.xml from b drive");
		File file = new File("b:\\JAXBfile.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
 
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		System.out.println("Creating UnMarshaller");
		customer = (Customer) jaxbUnmarshaller.unmarshal(file);
		System.out.println("Cutomer name from object formed : " + customer.name);
		System.out.println("Customer object formed and UnMarshaller task completed");
	  } catch (JAXBException e) {
		e.printStackTrace();
	  }
 
	}
}