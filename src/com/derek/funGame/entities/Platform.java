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
	protected Random r = new Random();
	
	public Platform(int zIndex, int x, int y, int width, int height) {
		super(zIndex);
		setSprite(new Rectangle(x, r.nextInt(500), width, height));
		CollisionSystem.getInstance().register(this);
	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		//sprite movement
		sprite.setX((float) (sprite.getX() - .5));
		//sprite reset if off screen
		if (sprite.getX() < -200) {
			sprite.setX(960);
			if (sprite.getY() > 295) {
				sprite.setY(sprite.getY() - r.nextInt(245));
			} else if (sprite.getY() <= 295) {
				sprite.setY(sprite.getY() + r.nextInt(245));
			}
		}
	}

	@Override
	public void render(GameContainer container, Graphics g)
			throws SlickException {
		//default sprite
		g.setColor(Color.transparent);
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
