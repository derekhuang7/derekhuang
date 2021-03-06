package com.derek.funGame.entities;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import com.derek.funGame.Game;
import com.derek.funGame.events.Event;
import com.derek.funGame.events.EventHandler;
import com.derek.funGames.collisions.Collidable;
import com.derek.funGames.collisions.CollisionSystem;

public class Box2 extends BaseEntity implements Collidable{
	
	public enum PlayerColor {
		RED,
		BLUE
	}
	
	private Rectangle sprite;
	protected boolean onDeck;
	protected boolean isJumping = false;
	private PlayerColor playerColor = PlayerColor.RED;
	protected double fall = 0;
	protected double dVelocity = 5882.41;
	private boolean isGameOverBox = true;
	private int delay = 0;
	Image stickfigure = null;

	public Box2(int zIndex, int x, int y, int width, int height) {
		super(zIndex);
		sprite = new Rectangle(x, y, width, height);
		
		CollisionSystem.getInstance().register(this);
		this.addEventListener("CollisionEvent", new EventHandler() {

			@Override
			public void handleEvent(Event e) {
				//this below is only for RestartPlatform
				onDeck = true;
				if(e.data[0] instanceof RestartPlatform) {
					isJumping = false;
					fall = 0;
					RestartPlatform F = (RestartPlatform) e.data[0];
					sprite.setY(F.getSprite().getY() - 50);
				}
				//here ends the RestartPlatform
				//here begins PlatformBlue
				if (playerColor == PlayerColor.RED) {
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
				} else if (playerColor == PlayerColor.BLUE){
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
		//Reset
		if (sprite.getY() >= container.getHeight() + 270) {
			Game.invokeEvent(new Event("GameOver"));
			delay += 70 * .001 * delta;
			if (delay > 250) {
				delay = 0;
				isGameOverBox = true;
			}
		}
		if (isGameOverBox == true & container.getInput().isKeyPressed(Input.KEY_ENTER)) {
			isGameOverBox = false;
			fall = 0;
			sprite.setX(0);
			sprite.setY(0);
			Game.invokeEvent(new Event("RestartGame"));
		}
		
		//gravity & jump
		if (!onDeck) {
			sprite.setY( (float) (sprite.getY() + (fall) * .001 * delta));
			fall += dVelocity * .001 * delta;
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
		//phase changer
		if (container.getInput().isKeyPressed(Input.KEY_SPACE)) {
			if(playerColor == PlayerColor.RED)
				playerColor = PlayerColor.BLUE;
			else
				playerColor = PlayerColor.RED;
		}	

	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		stickfigure = new Image("res/images.png");

		if (playerColor == PlayerColor.RED) {
			g.drawImage(stickfigure, (float) (sprite.getX() - 25), sprite.getY() + 20, Color.red);
		}
		if (playerColor == PlayerColor.BLUE) {
			g.drawImage(stickfigure, (float) (sprite.getX() - 25), sprite.getY() + 20, Color.blue);
		}
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
