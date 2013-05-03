package view;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
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
	
	public PauseView(int worldWidth, int worldHeight){
		this.worldWidth = worldWidth;
		this.worldHeight = worldHeight;
		this.buttonWidth = worldWidth/2;
		this.buttonHeight = (2*worldHeight)/15;
		this.isMarked = 0;
		buttonList = new ArrayList<Rectangle>();
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
			/*Create image of game TODO*/
				//draw(sbg.getState(Game.IN_GAME));
				//gather contents from the play screen and make a new Image
				//get graphics and render your scene in the new Image
				//set Image as background
				//create a fill rect for opacity and color if needed

				/*if you pause, you keep the last state id in memory and you do a transition to your paused state
				 * if you resume you get the last state back by id and everything "resumes" automatically without 
				 * doing noting, the state is paused (not rendered or updated) until you go back to that state*/

			/*Create pause menu*/
			Rectangle pauseMenu = new Rectangle(worldWidth/4, worldHeight/5, worldWidth/2, (2*worldHeight)/3); //x, y, width, height
			g.draw(pauseMenu);
			g.setColor(Color.green);
			
			/*Create "buttons" in menu*/
			//Start coordinates same as pause menu
			int buttonX = worldWidth/4;
			int buttonY = worldHeight/5;
			for(int i = 0; i < 5; i++){
				this.buttonList.add(new Rectangle(buttonX, buttonY, buttonWidth, buttonHeight));
				
				if(buttonList.indexOf(buttonList.get(i)) == isMarked) {
					g.fill(buttonList.get(i));
				} else {
					g.draw(buttonList.get(i));
				}
				//increase Y with buttonHeight to place the buttons underneath each other
				buttonY = buttonY + buttonHeight;
			}
	}
	
	/*Move marker if key is pressed down*/
	public void markButtonDown() {
		isMarked = ++isMarked % 5;
	}
	
	/*Move marker if key is pressed up*/
	public void markButtonUp() {
		isMarked = (isMarked + 4) %5; //add 4 to make positive (--isMarked + 5)
	}
	
	public int getIsMarked(){
		return isMarked;
	}
}
