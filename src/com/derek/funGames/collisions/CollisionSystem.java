package com.derek.funGames.collisions;

import java.util.ArrayList;

public class CollisionSystem {
	private static CollisionSystem instance = new CollisionSystem();
	
	private ArrayList<Collidable> collisionList = new ArrayList<>();
	
	private CollisionSystem() {}
	
	public static CollisionSystem getInstance() {
		return instance;
	}
	
	public void register(Collidable c) {
		collisionList.add(c);
	}
	
	public void unregister(Collidable c) {
		collisionList.remove(c);
	}
	
	public void update() {
		Collidable c1;
		Collidable c2;
		
		for(int j=0; j < collisionList.size(); j++) {
			for(int k=j+1; k < collisionList.size(); k++) {
				c1 = collisionList.get(j);
				c2 = collisionList.get(k);
				if(c1.collidesWith(c2)) {
					c1.invokeEvent(new CollisionEvent(c2));
					c2.invokeEvent(new CollisionEvent(c1));
				}
			}
		}
	}
}
