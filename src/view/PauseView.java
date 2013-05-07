package view;

import java.util.ArrayList;

import model.Game;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

public class PauseView {
	private int worldWidth;
	private int worldHeight;
	private int buttonHeight;
	private int buttonWidth;
	private int isMarked;
	private ArrayList<Rectangle> buttonList;
	
	public PauseView(int worldWidth, int worldHeight) {
		this.worldWidth = worldWidth;
		this.worldHeight = worldHeight;
		this.buttonWidth = worldWidth/2;
		this.buttonHeight = (2*worldHeight)/15;
		this.isMarked = 0;
		buttonList = new ArrayList<Rectangle>();
	}
	
	//Make method that keeps track on which state to go back to TODO (multiple levels)

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		/*Draw illusion image of the game*/
		Image pauseBackground = new Image("pics/pauseBackground.png");
		g.drawImage(pauseBackground, 0, 0);
		
		/*Create a pause menu "box"*/
		g.setColor(new Color(new Color(1f, 1f, 1f, 1.5f)));
		g.fillRect(worldWidth/4, worldHeight/5, worldWidth/2, (2*worldHeight)/3);
		
		/*Create pause menu "buttons"*/
		//Start coordinates positioned so the menu is displayed in the middle and takes up 3/4 of the screen (height)
		int buttonX = worldWidth/4;
		int buttonY = worldHeight/5;
		for(int i = 0; i < 5; i++){
			this.buttonList.add(new Rectangle(buttonX, buttonY, buttonWidth, buttonHeight));

			if(buttonList.indexOf(buttonList.get(i)) == isMarked) {
				g.setColor(new Color(0.5f, 0.5f, 0.5f, 0.5f));
				g.fill(buttonList.get(i));
			} else {
				g.setColor(new Color(0f, 0f, 0f, 0f));
				g.draw(buttonList.get(i));
			}
			//increase Y with buttonHeight to place the buttons underneath each other
			buttonY = buttonY + buttonHeight;
		}
		/*Create text for each "button"*/
		//g.drawString("Resume", worldWidth/4, worldHeight/5);
		//g.drawString("Sound On/Off", x, y);
		//g.drawString("Music On/Off", x, y);
	}
	
	/*Move marker if key is pressed down*/
	public void markButtonDown() {
		isMarked = ++isMarked % 5;
	}
	
	/*Move marker if key is pressed up*/
	public void markButtonUp() {
		isMarked = (isMarked + 4) %5; //add 4 to make positive (--isMarked + 5)
	}
	
	public int getIsMarked() {
		return isMarked;
	}
}
