package com.derek.funGame.entities;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import com.derek.funGames.collisions.Collidable;
import com.derek.funGames.collisions.CollisionSystem;

public class RestartPlatform extends BaseEntity implements Collidable{
	
	private Rectangle sprite;
	
	public RestartPlatform(int zIndex, int x, int y, int width, int height) {
		super(zIndex);
		setSprite(new Rectangle(x, y, width, height));
		CollisionSystem.getInstance().register(this);
	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		//sprite movement
		sprite.setX((float) (sprite.getX() - ((375) * .001 * delta)));
	}

	@Override
	public void render(GameContainer container, Graphics g)
			throws SlickException {
		g.setColor(Color.yellow);
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
