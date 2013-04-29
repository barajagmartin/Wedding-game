package controller;


import java.io.FileNotFoundException;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;



public class Main {
	private static final String GAME_NAME = "Candy Monsters";
	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) {
		AppGameContainer app;
		try {
			app = new AppGameContainer(new GameController(GAME_NAME));
			app.setDisplayMode(1250, 700, false);
			app.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}