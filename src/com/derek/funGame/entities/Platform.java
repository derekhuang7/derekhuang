package com.derek.funGame.entities;

import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import com.derek.funGame.Game;
import com.derek.funGame.events.Event;
import com.derek.funGame.events.EventHandler;
import com.derek.funGames.collisions.Collidable;
import com.derek.funGames.collisions.CollisionSystem;

public class Platform extends BaseEntity implements Collidable{
	
	protected Rectangle sprite;
	protected Random r = new Random();
	private float hi;
	
	public Platform(int zIndex, int x, int y, int width, int height) {
		super(zIndex);
		setSprite(new Rectangle(x, r.nextInt(500), width, height));
		CollisionSystem.getInstance().register(this);
		
		Game.addEventListener("RestartGame", new EventHandler() {

			@Override
			public void handleEvent(Event e) {
				hi = 0;
			}
			
		});
	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		//sprite movement
		sprite.setX((float) (sprite.getX() - ((50 + hi) * .001 * delta)));
		hi = (float) (hi + (150 * .001 * delta));
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

	public void setSprite(Rectangle rectangle) {
		this.sprite = rectangle;
	}

}
