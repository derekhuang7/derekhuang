package com.derek.funGames.collisions;

import org.newdawn.slick.geom.Shape;

import com.derek.funGame.events.Event;

public interface Collidable {
	public Shape getCollisionBounds();
	
	public boolean collidesWith(Collidable c);
	
	public void invokeEvent(Event e);
}
