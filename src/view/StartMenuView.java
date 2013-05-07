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

public class StartMenuView {
	private int worldWidth;
	private int worldHeight;
	private int buttonWidth;
	private int buttonHeight;
	private int isMarked;
	private ArrayList<Rectangle> buttonList;

	public StartMenuView (int worldWidth, int worldHeight) {
		this.worldWidth = worldWidth;
		this.worldHeight = worldHeight;
		this.buttonWidth = worldWidth;
		this.buttonHeight = (2*worldHeight)/15;
		this.isMarked = 0;
		buttonList = new ArrayList<Rectangle>();
	}
	
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		g.drawImage(new Image("pics/bluebg.png"), 0, 0);
		
		/*Create start menu "buttons"*/
		int buttonX = 0;
		int buttonY = worldHeight/5;
		for(int i = 0; i < 5; i++){
			this.buttonList.add(new Rectangle(buttonX, buttonY, buttonWidth, buttonHeight));

			if(buttonList.indexOf(buttonList.get(i)) == isMarked) {
				g.setColor(new Color(0f, 0f, 0f, 0.4f));
				g.fill(buttonList.get(i));
			} else {
				g.setColor(new Color(0f, 0f, 0f, 0f));
				g.draw(buttonList.get(i));
			}
			//increase Y with buttonHeight to place the buttons underneath each other
			buttonY = buttonY + buttonHeight;
		}
		/*Create a label for each button*/
		g.setColor(Color.white);
		g.drawString("START GAME", (3*worldWidth)/7, worldHeight/4);

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
