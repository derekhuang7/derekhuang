package com.derek.funGame.entities;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;


public class Floor extends Platform{
	
	public Floor(int zIndex, int x, int y, int width, int height) {
		super(zIndex, x, y, width, height);
	}

	@Override
	public void render(GameContainer container, Graphics g)
			throws SlickException {
		// TODO Auto-generated method stub
		g.setColor(Color.yellow);
		g.fill(getSprite());
	}


}
