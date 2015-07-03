package com.derek.funGame.entities;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Background extends BaseEntity{
	
	Image Background = null;

	public Background(int zIndex) {
		super(zIndex);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		Background = new Image("res/Background.jpg");
		g.drawImage(Background, 0, 0, Color.green);
	}

}
