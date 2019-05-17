package com.cg.event.dao;
import com.cg.event.dto.Event;
import com.cg.event.exception.DelegateException;

import com.cg.event.dto.Delegate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cg.event.dto.Delegate;

@Repository("eventdao")
public class EventRepositoryImpl implements EventRepository {
	List<Delegate> delegateList=new ArrayList<Delegate>();
	List<Event> eventList =new ArrayList<Event>();
	
	public boolean save(Delegate delegate) {		
		delegateList.add(delegate);				
		return true;
	}	 
	public List<Event> showAllEvents() {		
		return eventList;
	}
	public List<Delegate> showAllDelegates() {
		return delegateList;
	}
	public boolean save(Event name) throws DelegateException {
		// TODO Auto-generated method stub
		eventList.add(name);
		return true;
	}
}