package com.derek.funGames.collisions;

import com.derek.funGame.events.Event;

public class CollisionEvent extends Event{
	
	public CollisionEvent(Object collider) {
		super("CollisionEvent", new Object[] {collider});
	}
}
