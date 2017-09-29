package com.soap.webservice.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.soap.webservice.beans.Person;

@WebService(endpointInterface = "com.soap.webservice.service.PersonService")  
public class PersonServiceImpl implements PersonService{

	private Map<Integer,Person> persons = new HashMap<Integer,Person>();
	
	@WebMethod
	public boolean addPerson(Person p) {
		if(persons.get(p.getId()) != null) 
			persons.remove(p.getId());
		persons.put(p.getId(), p);
		return true;
	}

	@WebMethod
	public boolean deletePerson(int id) {
		if(persons.get(id) == null) return false;
		persons.remove(id);
		return true;
	}

	@WebMethod
	public Person getPerson(int id) {
		return persons.get(id);
	}

	@WebMethod
	public Person[] getAllPersons() {
		Set<Integer> ids = persons.keySet();
		Person[] p = new Person[ids.size()];
		int i=0;
		for(Integer id : ids){
			p[i] = persons.get(id);
			i++;
		}
		return p;
	}


}
