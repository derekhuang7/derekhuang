package com.derekhuang.Game;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main {
	public static void main(String args[]) {
		try {
			AppGameContainer appgc;
			appgc = new AppGameContainer (new Game("This is the name of the Game, I guess"));
			appgc.setDisplayMode(960, 540, false);
			appgc.start();
		}
		catch (SlickException ex) {
			Logger.getLogger (Game.class.getName()).log(Level.SEVERE, null, ex);
		}
		
	}
}

