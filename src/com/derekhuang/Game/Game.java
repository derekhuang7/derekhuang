package com.derekhuang.Game;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Game extends BasicGame{

	public Game(String title) {
		super(title);

	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		for (int x = 0; x < 540; x++){
			g.setColor(Color.red);
			g.drawString("This is weird", 430, x);
			g.setColor(Color.yellow);
			g.drawRect(0, 0, 960, 540);
			g.setColor(Color.blue);
			g.drawRect(400, x, 200, 200);
		}
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		
	}

}
