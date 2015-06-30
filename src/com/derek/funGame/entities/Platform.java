package com.derek.funGame.entities;

import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import com.derek.funGames.collisions.Collidable;
import com.derek.funGames.collisions.CollisionSystem;

public class Platform extends BaseEntity implements Collidable{
	
	private Rectangle sprite;
	private Random r = new Random();
	
	public Platform(int zIndex, int x, int y, int width, int height) {
		super(zIndex);
		setSprite(new Rectangle(x, r.nextInt(500), width, height));
		CollisionSystem.getInstance().register(this);
	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		sprite.setX((float) (sprite.getX() - .5));
		if (sprite.getX() < -200) {
			sprite.setX(960);
			if (sprite.getY() > 250) {
				sprite.setY(sprite.getY() - r.nextInt(250));
			} else if (sprite.getY() <= 250) {
				sprite.setY(sprite.getY() + r.nextInt(270));
			}
		}
	}

	@Override
	public void render(GameContainer container, Graphics g)
			throws SlickException {
		// TODO Auto-generated method stub
		g.setColor(Color.blue);
		g.fill(getSprite());
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
