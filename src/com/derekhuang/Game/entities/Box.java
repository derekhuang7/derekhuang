package com.derekhuang.Game.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;

public class Box extends BaseEntities {

	public Box(Point point, int i, int j, int k) {
		super(point, i, j, k);
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		g.drawRect(position.getX(), position.getY(), width, height);
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		
	}
}
