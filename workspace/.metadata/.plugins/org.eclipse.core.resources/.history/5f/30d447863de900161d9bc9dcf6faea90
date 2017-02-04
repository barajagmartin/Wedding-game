package controller;



import model.Game;

import java.io.File;

import org.lwjgl.LWJGLUtil;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

/**
 * 
 * 
 * @author Josefin, Martin, Sara, Kino
 * This class, Main, is where the main method is located which creates and starts the game.
 */

public class Main {
	
	/**
	 * Creates and starts the game.
	 * Set icons on window
	 * Remove the FPS tag on screen
	 * @param args
	 */
	public static void main(String[] args) {
		AppGameContainer app;
		try {
			System.setProperty("java.library.path", "");
			System.setProperty("org.lwjgl.librarypath", new File("lib/native/" + LWJGLUtil.getPlatformName()).getAbsolutePath());
			
			app = new AppGameContainer(new GameController("Bröllopsspelet"));
			app.setDisplayMode(Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT, false);
			app.setShowFPS(false);
			app.setIcons(new String[]{"pics/icon16.png", "pics/icon32.png"});
			app.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}