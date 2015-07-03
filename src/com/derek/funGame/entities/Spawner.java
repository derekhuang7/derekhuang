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

	public static final int SPAWN_RATE = 900;
	
	Random r = new Random();
	private int x = 0;
	private int y = 0;
	private int timer = 0;
	private float gameTime = 0;
	private float hi = 0;
	private boolean isGameOver = true;
	private boolean gameStart = false;
	private int delay = 0;

	private static float movecell = 0;
	
	public Spawner(int zIndex) {
		super(zIndex);
		
		//f = new Floor(-1, 0, 700, 1200, 10);
		//EntityManager.getInstance().spawn(f);
		
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
				hi = 0;
				x = 1500;
				y = 295;
				timer = 1300;
				isGameOver = false;
				gameStart = true;
				EntityManager.getInstance().spawn(new RestartPlatform(-1, 0, 530, 1100 , 40));
				//f.setCoords(0, 530);
			}
			
		});
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		if (!isGameOver) {
			//Game time
			gameTime = (float) (gameTime + .001 * delta);
			hi = (float) (hi + (150 * .001 * delta));
		}
		if (!isGameOver) {
			movecell += 1 * .001 * delta;
		} else if (isGameOver){
			movecell = 0;
		}
		if(timer >= SPAWN_RATE & !isGameOver) {
			//Y random spawn
			if (y > 295) {
				y = y - r.nextInt(245);
			} else if (y <= 295) {
				y = y + r.nextInt(230);
			}
			//Entity spawner
			int a = r.nextInt(2);
			if (a == 0) {
				EntityManager.getInstance().spawn(new PlatformBlue(-1, x, y, 200, 20));
			} else if (a == 1) {
				EntityManager.getInstance().spawn(new PlatformRed(-1, x, y, 200, 20));
			}
			timer = 0;
		} else if (!isGameOver) {
			timer += (movecell * .001 * delta) + delta;
		}
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		//for the delay of "PREASS ENTER TO PLAY AGAIN"
		if (!isGameOver) {
			g.setColor(Color.white);
			g.drawString(gameTime + " seconds", 405, 50);
			g.setColor(Color.orange);
			g.drawString(hi + 50 + " m/s", 0, 0);
		}
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
			g.setColor(Color.orange);
			g.drawString(hi + 50 + " m/s", 0, 0);
			if (delay <= 208) {
				g.setColor(Color.green);
				g.fillRoundRect(376, 266, delay, 19, 100);
				g.setColor(Color.white);
				if ((delay >= 0 & delay < 13) | (delay >= 52 & delay < 65) | (delay >= 104 & delay < 117) | (delay >= 156 & delay < 169)) {
					g.drawString("Loading.", 440, 285);
				} else if ((delay >= 13 & delay < 26) | (delay >= 65 & delay < 78) | (delay >= 117 & delay < 130) | (delay >= 169 & delay < 182)) {
					g.drawString("Loading..", 440, 285);
				} else if ((delay >= 26 & delay < 39) | (delay >= 78 & delay < 91) | (delay >= 130 & delay < 143) | (delay >= 182 & delay < 195)) {
					g.drawString("Loading...", 440, 285);
				} else {
					g.drawString("Loading....", 440, 285);
				}
				g.drawRoundRect(375, 265, 210, 20, 100);
			}
			delay += 1;
			if (delay  > 208) {
				g.setColor(Color.green);
				g.fillRoundRect(376, 266, 208, 19, 100);
				g.setColor(Color.white);
				g.drawRoundRect(375, 265, 210, 20, 100);
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
			g.drawString("* You can only land on plates that are the opposite color.", 150, 230);
			g.drawString("    -(e.g. if you are red, you can land on blue plate, but", 150, 250);
			g.drawString("      you will fall right through a red plate.)", 150, 270);
			g.setColor(Color.red);
			g.drawString("--- PRESS ENTER TO START ---", 150, 310);
		}
	}

}
