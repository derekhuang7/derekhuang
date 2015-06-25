package com.derekhuang.Game.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Box extends BaseEntities {

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		g.drawRect(400, 300, 200, 200);
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {

	}

}
