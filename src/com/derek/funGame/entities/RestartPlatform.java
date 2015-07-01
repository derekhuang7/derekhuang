package com.derek.funGame.entities;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class RestartPlatform extends Platform{

	public RestartPlatform(int zIndex, int x, int y, int width, int height) {
		super(zIndex, x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		//sprite movement
	}
	
	@Override
	public void render(GameContainer container, Graphics g)
			throws SlickException {
		g.setColor(Color.black);
		g.fill(getSprite());
	}

}
