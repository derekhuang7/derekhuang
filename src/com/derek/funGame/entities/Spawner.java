package com.derek.funGame.entities;

import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.derek.funGame.EntityManager;
import com.derek.funGame.Game;
import com.derek.funGame.events.Event;
import com.derek.funGame.events.EventHandler;

public class Spawner extends BaseEntity{

	public static final int SPAWN_RATE = 1000;
	
	Random r = new Random();
	private int x = 960;
	private int y = 295;
	private int timer = 0;
	private float gameTime = 0;
	private boolean isGameOver = false;
	
	public Spawner(int zIndex) {
		super(zIndex);
		
		Game.addEventListener("GameOver", new EventHandler() {

			@Override
			public void handleEvent(Event e) {
				isGameOver = true;
			}
			
		});
		
		Game.addEventListener("RestartGame", new EventHandler() {

			@Override
			public void handleEvent(Event e) {
				gameTime = 0;
				x = 1500;
				y = 295;
				isGameOver = false;
				EntityManager.getInstance().spawn(new Floor(-1, 0, 530, 1200, 10));
			}
			
		});
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		if (!isGameOver) {
			//Game time
			gameTime = (float) (gameTime + .001 * delta);
		}
		if(timer >= SPAWN_RATE & !isGameOver) {
			//Y random spawn
			if (y > 295) {
				y = y - r.nextInt(245);
			} else if (y <= 295) {
				y = y + r.nextInt(245);
			}
			//Entity spawner
			int a = r.nextInt(2);
			if (a == 0) {
				EntityManager.getInstance().spawn(new PlatformBlue(-1, x, y, 200, 20));
			} else if (a == 1) {
				EntityManager.getInstance().spawn(new PlatformRed(-1, x, y, 200, 20));
			}
			timer = 0;
		} else {
			timer += delta;
		}
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		if(isGameOver) {
			g.setColor(Color.yellow);
			g.drawString("Game Over", 440, 240);
			g.setColor(Color.blue);
			g.drawString("Your time:", 439, 260);
			g.setColor(Color.red);
			g.drawString(gameTime + " seconds", 405, 285);
			g.setColor(Color.white);
			g.drawString("PRESS ENTER TO PLAY AGAIN", 373, 305);
		}
	}

}
