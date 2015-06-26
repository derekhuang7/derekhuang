package com.derek.funGame.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A class that defines the event system. This class should not be instantiated. Instead, it should be extended. (BaseEntity extends this already)
 * @author Isaac
 *
 */
public class EventSystem {
	
	public EventSystem() {};
	
	private final HashMap<String, ArrayList<EventHandler>> eventHandlers = new HashMap<>();
	
	/**
	 * Adds an EventLister to this object. The listener will be invoked whenever this entity, or other objects, calls it's invokeEvent method.
	 * @param e The event to listen for
	 * @param handler The EventHandler to handle the event
	 */
	public void addEventListener(Event e, EventHandler handler) {
		addEventListener(e.name, handler);
	}
	
	public void addEventListener(String eventName, EventHandler handler) {
		ArrayList<EventHandler> newList;
		
		if(eventHandlers.get(eventName) == null)
			newList = new ArrayList<EventHandler>();
		else
			newList = eventHandlers.get(eventName);
		
		newList.add(handler);
		eventHandlers.put(eventName, newList);
	}
	
	/**
	 * Invokes an event in relation to the entity. It will call the EventHandler of other objects that have attached themselves to this event.
	 * @param e The event to invoke
	 */
	public void invokeEvent(Event e) {
		List<EventHandler> eventHandlerList = eventHandlers.get(e.name);
		if(eventHandlerList != null) {
			for(EventHandler h : eventHandlerList)
				h.handleEvent(e);
		}
	}
}
