package com.derek.funGame.entities;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Floor extends BaseEntity{
	
	protected static float x;
	protected static float y;
	protected float width;
	protected float height;

	public Floor(int zIndex, int x, int y, int width, int height) {
		super(zIndex);
		this.x = x;
		Floor.y = y;
		this.width = width;
		this.height = height;
	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer container, Graphics g)
			throws SlickException {
		// TODO Auto-generated method stub
		g.setColor(Color.yellow);
		g.fillRect(x, y, width, height);
	}

}
