package com.derek.funGame.entities;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import com.derek.funGames.collisions.CollisionSystem;

public class PlatformBlue extends Platform{
	
	public PlatformBlue(int zIndex, int x, int y, int width, int height) {
		super(zIndex, x, y, width, height);
		setSprite(new Rectangle(x, y, width, height));
		CollisionSystem.getInstance().register(this);
	}

	@Override
	public void render(GameContainer container, Graphics g)
			throws SlickException {
		g.setColor(Color.blue);
		g.fill(getSprite());
	}

}
