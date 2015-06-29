package com.derek.funGame.entities;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Floor extends BaseEntity{


	public Floor(int zIndex, int i, int j, int k, int l) {
		super(zIndex);
		// TODO Auto-generated constructor stub
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
		g.fillRect(0, 500, 960, 80);
	}

}
