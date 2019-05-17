package com.cg.event.ui;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.cg.event.config.JavaConfig;
import com.cg.event.dao.EventRepository;
import com.cg.event.dto.Address;
import com.cg.event.dto.Delegate;
import com.cg.event.dto.Event;
import com.cg.event.exception.DelegateException;
import com.cg.event.service.DelegateService;
import com.cg.event.service.DelegateServiceImpl;
import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
@Component
public class Main
{
	static DelegateService service;
	@Autowired
	DelegateService serve;

	@PostConstruct
	public void init() {
		service=this.serve;	
	}
	public static void main(String[] args) throws DelegateException
	{		
		AnnotationConfigApplicationContext app= new AnnotationConfigApplicationContext(JavaConfig.class);
		Scanner sc=new Scanner(System.in);	
		List<Event> events = new ArrayList<Event>();
		Event e=app.getBean(Event.class);

		Random rand = new Random(); 
		int randomvalue = rand.nextInt(10000000); 
		//	final Logger LOGGER = Logger.getLogger("EventLogger");   
		//	int rand_id=0; 
		//	rand_id++;
		System.out.println("\nEnter your name");
		String name=sc.nextLine();

		System.out.println("Enter Address : building name");
		String building=sc.nextLine();

		System.out.println("Enter street");
		String street=sc.nextLine();

		System.out.println("Enter city");
		String city=sc.nextLine();
		
		System.out.println("Enter the name of the event you want to attend");
		String eventname=sc.nextLine();
		
		System.out.println("Enter the event date in dd-mm-yyyy format");
		String dates=sc.next();
			
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
		Date date=null;
		try {
			date = dateFormat.parse(dates);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}					
		System.out.println("Enter the city where event is being hosted");
		String eventcity=sc.next();
		Event eventone=app.getBean(Event.class);								 

		eventone.setId(randomvalue);
		eventone.setEventName(eventname);
		eventone.setDate(date);
		eventone.setCity(city);
		events.add(eventone);													

		//service.registerEvent(eventone);									 
		//	Delegate d=new Delegate(randomvalue,name,new Address(randomvalue, building,street,city),events);

		Address address=app.getBean(Address.class);
		address.setId(randomvalue);
		address.setBuilding(building);
		address.setStreet(street);
		address.setCity(city);		

		Delegate d=app.getBean(Delegate.class);
		d.setId(randomvalue);
		d.setName(name);
		d.setAddress(address);
		d.setEvents(events);

		System.out.println(service.registerDelegate(d));                              			 //register and display delegate		
		service.registerEvent(eventone);														 //register event
		System.out.println("\nThe events available are");
		List <Event> showevents=service.showEvents();											 //show all events
		System.out.println(showevents);

		System.out.println("\nEnter the event name for more details");  						 //displaying event info
		String eventdetail=sc.next();

		e.setEventName(eventdetail);
		Event eventlist=service.eventInfo(e);
		System.out.println(eventlist);
	}
}