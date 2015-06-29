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
	protected double fall = 1;

	public Box2(int zIndex, int x, int y, int width, int height) {
		super(zIndex);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		if (y < 400) {
			fall = 1.198 * fall;
			y += 39.8 * fall * .001 * delta;
		} else if (y < 340 & isJumping == true) {
			fall = 1;
			isJumping = false;
		} else {
			y = 400;
			fall = 0;
		}
		
		if(container.getInput().isKeyDown(Input.KEY_UP) & isJumping == false) {
			isJumping = true;
			fall = 1;
			y = 350;
		}
		if(container.getInput().isKeyDown(Input.KEY_RIGHT) & x < 860) {
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
