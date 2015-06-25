package com.derekhuang.Game.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;

public abstract class BaseEntities {
	protected Point position;
	protected int width;
	protected int height;
	protected double rotation;
	
	public BaseEntities() {
		this.position = new Point(0, 0);
		this.width = 0;
		this.height = 0;
		this.rotation = 0;
	}
	
	public BaseEntities(Point p) {
		this.position = p;
	}
	
	public BaseEntities(Point p, int width, int height, double rotation) {
		this.position = p;
		this.width = width;
		this.height = height;
		this.rotation = rotation;
	}
	
	public abstract void render(GameContainer container, Graphics g) throws SlickException;
	public abstract void update(GameContainer container, int delta) throws SlickException;
}
