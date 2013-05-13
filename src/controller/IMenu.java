package controller;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public interface IMenu {
	/**Create buttons for the menu*/
	public void createButtons(GameContainer gc, Graphics g) throws SlickException;
	/**Mark the next button*/
	public void markButtonDown();
	/**Mark the previous button*/
	public void markButtonUp();
	
}
