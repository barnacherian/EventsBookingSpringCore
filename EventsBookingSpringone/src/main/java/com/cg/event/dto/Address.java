package com.cg.event.dto;

import org.springframework.stereotype.Component;

@Component
public class Address 
{	
	private int id;
	private String building;
	private String street;
	private String city;
	public Address() {
		// TODO Auto-generated constructor stub
	}	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Address(int id, String building, String street, String city) {
		super();
		this.id = id;
		this.building = building;
		this.street = street;
		this.city = city;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", building=" + building + ", street=" + street + ", city=" + city + "]";
	}
}