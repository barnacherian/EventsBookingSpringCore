package com.cg.event.dto;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class Delegate
{
	private int id;
	private String name;
	
	private Address address;
	
	private List<Event> events;
	public Delegate() {	
	}
	
	public Delegate(int id, String name, Address address, List<Event> events) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.events = events;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Event> getEvents() {
		return events;
	}
	public void setEvents(List<Event> events) {
		this.events = events;
	}
	@Override
	public String toString() {
		return "Delegate [id=" + id + ", name=" + name + ", address=" + address + ", events=" + events + "]";
	}			
}
