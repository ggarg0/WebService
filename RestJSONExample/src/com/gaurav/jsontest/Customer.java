package com.gaurav.jsontest;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonPropertyOrder({ "name", "id", "date", "address", "city", "country" })
@JsonRootName(value = "Customer")
public class Customer {

	private String id;
	
	@JsonProperty("custName")
	private String name;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@JsonProperty("custDate")
	private Date date;
	
	@JsonIgnore
	private String address;
	
	private String city;
	
	@JsonProperty("custCountry")
	private String country;

	public Customer() {
	}

	public Customer(String id, String name, Date date, String address, 
			String city, String country) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.address = address;
		this.city = city;
		this.country = country;
	}
	

	@JsonGetter(value = "CustId")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	@JsonSetter(value = "CustCity")
	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", date=" + date + ", "
				+ "address=" + address + ", city=" + city
				+ ", country=" + country + "]";
	}

}