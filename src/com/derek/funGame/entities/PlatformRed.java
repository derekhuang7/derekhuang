package com.derek.funGame.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import com.derek.funGames.collisions.CollisionSystem;

public class PlatformRed extends Platform{
	
	Image Platform2 = null;
	
	public PlatformRed(int zIndex, int x, int y, int width, int height) {
		super(zIndex, x, y, width, height);
		setSprite(new Rectangle(x, y, width, height));
		CollisionSystem.getInstance().register(this);
	}

	@Override
	public void render(GameContainer container, Graphics g)
			throws SlickException {
		Platform2 = new Image("res/Platform2.png");
		g.drawImage(Platform2, (float) (sprite.getX() - 10), sprite.getY() - 5);
	}

}
