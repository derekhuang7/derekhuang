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

	public static final int SPAWN_RATE = 1300;
	
	Random r = new Random();
	private int x = 0;
	private int y = 0;
	private int timer = 0;
	private Floor f;
	private float gameTime = 0;
	private boolean isGameOver = true;
	private boolean gameStart = false;
	private int delay = 0;
	private static float movecell = 0;
	
	public Spawner(int zIndex) {
		super(zIndex);
		
		f = new Floor(-1, 0, 700, 1200, 10);
		EntityManager.getInstance().spawn(f);
		
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
				x = 960;
				y = 295;
				movecell = 0;
				timer = 0;
				isGameOver = false;
				gameStart = true;
				f.setCoords(0, 530);
			}
			
		});
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		if (!isGameOver) {
			//Game time
			gameTime = (float) (gameTime + .001 * delta);
		}
		
		movecell += .007;
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
			timer += movecell + delta;
		}
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		//for the delay of "PREASS ENTER TO PLAY AGAIN"
		if(!isGameOver) {
			delay = 0;
		}
		//End game words
		if(isGameOver & gameStart) {
			g.setColor(Color.yellow);
			g.drawString("Game Over", 440, 200);
			g.setColor(Color.blue);
			g.drawString("Your time:", 439, 220);
			g.setColor(Color.red);
			g.drawString(gameTime + " seconds", 405, 245);
			if (delay <= 180) {
				g.setColor(Color.green);
				g.fillRoundRect(390, 266, delay, 19, 100);
				g.setColor(Color.white);
				if ((delay >= 0 & delay < 20) | (delay >= 60 & delay < 80) | (delay >= 120 & delay < 140)) {
					g.drawString("Loading.", 440, 285);
				} else if ((delay >= 20 & delay < 40) | (delay >= 80 & delay < 100) | (delay >= 140 & delay < 160)) {
					g.drawString("Loading..", 440, 285);
				} else {
					g.drawString("Loading...", 440, 285);
				}
				g.drawRoundRect(389, 265, 182, 20, 100);
			}
			delay += 1;
			if (delay  > 180) {
				g.setColor(Color.green);
				g.fillRoundRect(390, 266, 180, 19, 100);
				g.setColor(Color.white);
				g.drawRoundRect(389, 265, 182, 20, 100);
				g.drawString("<<< PH4SE RUNN3R >>>", 390, 265);
				g.drawString("PRESS ENTER TO PLAY AGAIN", 373, 305);
			}
		} else if (!gameStart) {
			g.setColor(Color.green);
			g.drawString("<<< PH4SE RUNN3R >>>", 390, 100);
			g.setColor(Color.white);
			g.drawString("Made by Derek Huang", 395, 120);
			g.setColor(Color.yellow);
			g.drawString("Instructions:", 100, 170);
			g.setColor(Color.white);
			g.drawString("* Use left/right keys to move side to side and up key to jump.", 150, 190);
			g.drawString("* Use the spacebar to change phases (red or blue).", 150, 210);
			g.drawString("* You can only land on blocks that is the opposite color.", 150, 230);
			g.drawString("    -(e.g. if you are red, you can land blue blocks, but you will", 150, 250);
			g.drawString("      fall right through a red block.)", 150, 270);
			g.setColor(Color.red);
			g.drawString("--- PRESS ENTER TO START ---", 150, 310);
		}
	}

}
