package com.derek.funGame.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import com.derek.funGames.collisions.CollisionSystem;

public class PlatformBlue extends Platform{
	
	Image Platform = null;
	
	public PlatformBlue(int zIndex, int x, int y, int width, int height) {
		super(zIndex, x, y, width, height);
		setSprite(new Rectangle(x, y, width, height));
		CollisionSystem.getInstance().register(this);
	}

	@Override
	public void render(GameContainer container, Graphics g)
			throws SlickException {
		Platform = new Image("res/Platform.png");
		g.drawImage(Platform, (float) (sprite.getX() - 10), sprite.getY() - 5);
	}

}
