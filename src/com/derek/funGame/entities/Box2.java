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
	protected double dVelocity = 8.98;

	public Box2(int zIndex, int x, int y, int width, int height) {
		super(zIndex);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		if (y == 449 & isJumping == true) {
			isJumping = false;
		} else if (y < 450) {
			y = (float) (y + (fall) * .001 * delta);
			fall += dVelocity;
		} else {
			y = 450;
		}
		
		if(container.getInput().isKeyDown(Input.KEY_UP) & isJumping == false & y == 450) {
			isJumping = true;
			fall = -1700;
			y = 449;
		}
		if(container.getInput().isKeyDown(Input.KEY_RIGHT) & x < 910) {
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
