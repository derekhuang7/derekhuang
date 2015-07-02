package com.derek.funGame;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main {

	public static void main(String[] args) {
		try {
			AppGameContainer app = new AppGameContainer(new Game("Phase Runner"));
			app.setShowFPS(true);
			app.setDisplayMode(960, 540, false);
			app.setTargetFrameRate(60);
			app.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}
