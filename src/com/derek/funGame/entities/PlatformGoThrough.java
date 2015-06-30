package com.derek.funGame.entities;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class PlatformGoThrough extends BaseEntity{

	protected static float x;
	protected static float y;
	protected static float width;
	protected float height;

	public PlatformGoThrough(int zIndex, int x, int y, int width, int height) {
		super(zIndex);
		PlatformGoThrough.x = x;
		PlatformGoThrough.y = y;
		PlatformGoThrough.width = width;
		this.height = height;
	}

	public static boolean platformExist(float x) {
		if (x < PlatformGoThrough.x + PlatformGoThrough.width & x > PlatformGoThrough.x - 50) {
			return true;
		} else {
			return false;
		}	
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
		g.setColor(Color.blue);
		g.fillRect(x, y, width, height);
	}

}

