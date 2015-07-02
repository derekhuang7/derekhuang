package com.derek.funGame;

import java.io.File;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main {

	public static void main(String[] args) {
		System.setProperty("java.library.path", "libs");
		System.setProperty("org.lwjgl.librarypath", new File("libs/natives").getAbsolutePath());
		
		try {
			AppGameContainer app = new AppGameContainer(new Game("Phase Runner"));
			app.setShowFPS(false);
			app.setDisplayMode(960, 540, false);
			app.setTargetFrameRate(60);
			app.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}
