package com.derek.funGames.collisions;

import org.newdawn.slick.geom.Shape;

import com.derek.funGame.events.Event;

public interface Collidable {
	public Shape getCollisionBouds();
	
	public boolean collidesWith(Collidable c);
	
	public void invokeEvent(Event e);
}
