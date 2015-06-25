package com.derekhuang.Game;

import java.util.ArrayList;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.derekhuang.Game.entities.BaseEntities;

public class Game extends BasicGame{

	private ArrayList<BaseEntities> entityList;
	
	public Game(String title) {
		super(title);
		this.entityList = new ArrayList<BaseEntities> ();
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		for (BaseEntities e : entityList){
			e.render(container, g);
		}

	}

	@Override
	public void init(GameContainer container) throws SlickException {
		
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		for (int i = 0; i < entityList.size(); i++) {
			entityList.get(i).update(container, delta);
		}
	}
}
