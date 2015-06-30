package com.derek.funGame.entities;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Box2 extends BaseEntity{
	
	protected float x;
	protected float y;
	protected float width;
	protected float height;
	protected boolean isJumping = false;
	protected double fallc = 0;
	protected double fall = 0;
	protected float initialY = y;
	protected double dVelocity = 4.98;

	public Box2(int zIndex, int x, int y, int width, int height) {
		super(zIndex);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		if (y == PlatformGoThrough.y - 50 & isJumping == true & PlatformGoThrough.platformExist(x)) {
			isJumping = false;
		} else if (y < PlatformGoThrough.y - 50 & PlatformGoThrough.platformExist(x)) {
			y = (float) (y + (fall) * .001 * delta);
			fall += dVelocity;
		} else if (y > PlatformGoThrough.y - 50 & y < PlatformGoThrough.y + 20 & fall < 0 & PlatformGoThrough.platformExist(x)) {
			y = (float) (y + (fall) * .001 * delta);
			fall += dVelocity;
		} else if (container.getInput().isKeyDown(Input.KEY_DOWN)) {
			y = (float) (y + (fall) * .001 * delta);
			fall += dVelocity;
		} else if (y > PlatformGoThrough.y - 50 & y < PlatformGoThrough.y + 20 & PlatformGoThrough.platformExist(x)) {
			y = PlatformGoThrough.y - 50;
		}
		
		if (y == Floor.y - 50 & isJumping == true) {
			isJumping = false;
		} else if (y < Floor.y - 50 & PlatformGoThrough.platformExist(x) == false) {
			y = (float) (y + (fall) * .001 * delta);
			fall += dVelocity;
		} else if (y < Floor.y - 50 & y > PlatformGoThrough.y + 20 & PlatformGoThrough.platformExist(x)) {
			y = (float) (y + (fall) * .001 * delta);
			fall += dVelocity;
		} else if (y > Floor.y - 50){
			y = Floor.y - 50;
		}
		
		
		if (container.getInput().isKeyDown(Input.KEY_UP) & isJumping == false & (y == Floor.y - 50 | y == PlatformGoThrough.y - 50)) {
			isJumping = true;
			fall = -1700;
			if (y == Floor.y - 50) {
				y = Floor.y - 51;
			}
			if (y == PlatformGoThrough.y - 50) {
				y = PlatformGoThrough.y - 51;
			}
		}
		
		if (container.getInput().isKeyDown(Input.KEY_RIGHT) & x < 910) {
			x += 750 * 0.001f * delta;
		}
		if (container.getInput().isKeyDown(Input.KEY_LEFT) & x > 0) {
			x -= 750 * 0.001f * delta;
		}
		
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		g.setColor(Color.red);
		g.fillRect(x, y, width, height);
	}

}
