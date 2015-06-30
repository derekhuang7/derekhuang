package com.derek.funGame.entities;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import com.derek.funGame.events.Event;
import com.derek.funGame.events.EventHandler;
import com.derek.funGames.collisions.Collidable;
import com.derek.funGames.collisions.CollisionSystem;

public class Box2 extends BaseEntity implements Collidable{
	
	private Rectangle sprite;
	protected boolean onDeck;
	protected boolean isJumping = false;
	private int spaceIsHeld = 0;
	protected double fall = 0;
	protected double dVelocity = 4.98;

	public Box2(int zIndex, int x, int y, int width, int height) {
		super(zIndex);
		sprite = new Rectangle(x, y, width, height);
		
		CollisionSystem.getInstance().register(this);
		this.addEventListener("CollisionEvent", new EventHandler() {

			@Override
			public void handleEvent(Event e) {
				//this below is only for floor (delete later)
				onDeck = true;
				if(e.data[0] instanceof Floor) {
					isJumping = false;
					fall = 0;
					Floor F = (Floor) e.data[0];
					sprite.setY(F.getSprite().getY() - 50);
				}
				//here ends the Floor
				//here begins PlatformBlue
				if (spaceIsHeld == 0) {
					if(e.data[0] instanceof PlatformBlue & fall < 0) {
						isJumping = false;
						fall = 0;
						PlatformBlue PB = (PlatformBlue) e.data[0];
						sprite.setY(PB.getSprite().getY() + 21);
						onDeck = false;
						isJumping = true;
					} else if (e.data[0] instanceof PlatformBlue & fall > 0) {
						isJumping = false;
						fall = 0;
						PlatformBlue PB = (PlatformBlue) e.data[0];
						sprite.setY(PB.getSprite().getY() - 50);
						onDeck = false;
					} else {
						onDeck = false;
					}
				//here ends PlatformBlue
				//here begins PlatformRed
				} else if (spaceIsHeld == 1){
					if(e.data[0] instanceof PlatformRed & fall < 0) {
						isJumping = false;
						fall = 0;
						PlatformRed PR = (PlatformRed) e.data[0];
						sprite.setY(PR.getSprite().getY() + 21);
						onDeck = false;
						isJumping = true;
					} else if (e.data[0] instanceof PlatformRed & fall > 0) {
						isJumping = false;
						fall = 0;
						PlatformRed PR = (PlatformRed) e.data[0];
						sprite.setY(PR.getSprite().getY() - 50);
						onDeck = false;
					} else {
						onDeck = false;
					}
				}
				//here ends PlatformRed
			}
		});
	}
	
	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		//gravity & jump
		if (!onDeck) {
			sprite.setY( (float) (sprite.getY() + (fall) * .001 * delta));
			fall += dVelocity;
		}
		//Key input
		if (container.getInput().isKeyDown(Input.KEY_RIGHT) & sprite.getX() < 910) {
			sprite.setX(sprite.getX() + 750 * 0.001f * delta);
		}
		if (container.getInput().isKeyDown(Input.KEY_LEFT) & sprite.getX() > 0) {
			sprite.setX(sprite.getX() - 750 * 0.001f * delta);
		}
		if (container.getInput().isKeyDown(Input.KEY_UP) & isJumping == false) {
			isJumping = true;
			fall = -1700;
			sprite.setY(sprite.getY() - 1);
			onDeck = false;
		}

	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		//phase changer
		if (container.getInput().isKeyDown(Input.KEY_SPACE)) {
			spaceIsHeld = 1;
			g.setColor(Color.blue);
		} else {
			spaceIsHeld = 0;
			g.setColor(Color.red);
		}
		g.fill(sprite);
	}

	@Override
	public Shape getCollisionBounds() {
		// TODO Auto-generated method stub
		return sprite;
	}

	@Override
	public boolean collidesWith(Collidable c) {
		// TODO Auto-generated method stub
		return sprite.intersects(c.getCollisionBounds());
	}

}
