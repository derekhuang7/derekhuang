package com.derek.funGame.events;

import org.newdawn.slick.command.Command;

import com.derek.funGame.Game;

/**
 * Command that invokes an event when run. For use in InputBindings
 * @author Isaac
 *
 */
public class CommandEvent implements Command {
	private Event e;
	private EventSystem destination;
	
	public CommandEvent(Event e) {
		this.e = e;
		destination = null;
	}
	
	public CommandEvent(Event e, EventSystem destination) {
		this.e = e;
		this.destination = destination;
	}
	
	public void invokeEvent() {
		if(destination == null)
			Game.invokeEvent(e);
		else
			destination.invokeEvent(e);
	}
}
