package com.derek.funGame.entities;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class PlatformHard extends BaseEntity{

	protected float x;
	protected float y;
	protected float width;
	protected float height;

	public PlatformHard(int zIndex, int x, int y, int width, int height) {
		super(zIndex);
		this.x = x;
		this.y = y;
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
		g.setColor(Color.cyan);
		g.fillRect(x, y, width, height);
	}

}
