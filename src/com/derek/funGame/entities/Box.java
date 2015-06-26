package com.derek.funGame.entities;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class Box extends BaseEntity{

	private Rectangle box;
	
	public Box(int zIndex, int x, int y, int width, int height) {
		super(zIndex);
		box = new Rectangle(x, y, width, height);
	}
	
	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		g.setColor(Color.white);
		g.fill(box);
	}

}
