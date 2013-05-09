package controller;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public interface IMenu {
	public void createButtons(Graphics g) throws SlickException;
	public void markButtonDown();
	public void markButtonUp();
	
}
