package com.derek.funGame.entities;

import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import com.derek.funGame.EntityManager;
import com.derek.funGame.Game;
import com.derek.funGame.events.Event;
import com.derek.funGame.events.EventHandler;
import com.derek.funGames.collisions.Collidable;
import com.derek.funGames.collisions.CollisionSystem;

public class Platform extends BaseEntity implements Collidable{
	
	protected Rectangle sprite;
	protected Random r = new Random();
	private double move = 0;
	
	public Platform(int zIndex, int x, int y, int width, int height) {
		super(zIndex);
		setSprite(new Rectangle(x, r.nextInt(500), width, height));
		CollisionSystem.getInstance().register(this);
	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		//sprite movement
		Game.addEventListener("RestartGame", new EventHandler() {

			@Override
			public void handleEvent(Event e) {
				move = 0;
			}
			
		});
		sprite.setX((float) (sprite.getX() - (2 + move)));
		move += .055;
	}

	@Override
	public void render(GameContainer container, Graphics g)
			throws SlickException {

	}

	@Override
	public Shape getCollisionBounds() {
		return getSprite();
	}

	@Override
	public boolean collidesWith(Collidable c) {
		return getSprite().intersects(c.getCollisionBounds());
	}

	public Rectangle getSprite() {
		return sprite;
	}

	public void setSprite(Rectangle sprite) {
		this.sprite = sprite;
	}

}
