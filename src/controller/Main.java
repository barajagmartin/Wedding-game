package controller;



import model.Game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;



public class Main {
	private static final String GAME_NAME = "Candy Monsters";
	
	/**
	 * Creates and starts the game.
	 * Set icons on window
	 * Remove the FPS tag on screen
	 * @param args
	 */
	public static void main(String[] args) {
		AppGameContainer app;
		try {
			app = new AppGameContainer(new GameController(GAME_NAME));
			app.setDisplayMode(Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT, false);
			app.setShowFPS(false);
			app.setIcons(new String[]{"pics/icon16.png", "pics/icon32.png"});
			app.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}