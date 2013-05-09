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

import controller.IMenu;

import utils.MenuUtils;

public class StartMenuView implements IMenu {
	private int buttonWidth;
	private int buttonHeight;
	private int isMarked;
	private ArrayList<Rectangle> buttonList;

	public StartMenuView () {
		this.buttonWidth = Game.WINDOW_WIDTH;
		this.buttonHeight = (2*Game.WINDOW_HEIGHT)/15;
		this.isMarked = 0;
		buttonList = new ArrayList<Rectangle>();
	}
	
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		/*Add background and title*/
		g.drawImage(new Image("pics/bluebg.png"), 0, 0);
		g.drawImage(new Image("pics/candy_monsters_orange.png"), 0, 0);
		createButtons(g);
	}
	
	@Override
	public void createButtons(Graphics g) throws SlickException{
		//start position
		int buttonX = 0;
		int buttonY = Game.WINDOW_HEIGHT/7;
		for(int i = 0; i < 6; i++){
			this.buttonList.add(new Rectangle(buttonX, buttonY, buttonWidth, buttonHeight));

			if(buttonList.indexOf(buttonList.get(i)) == isMarked) {
				g.setColor(new Color(0f, 0f, 0f, 0.5f));
				g.fill(buttonList.get(i));
			} else {
				g.setColor(new Color(0f, 0f, 0f, 0f));
				g.draw(buttonList.get(i));
			}
			/*Add labels to buttons*/
			switch(i) {
				case 0: g.drawImage(new Image("pics/start_game.png"), buttonX, buttonY);
						break;
				case 1: g.drawImage(new Image("pics/highscore.png"), buttonX, buttonY);
						break;
				case 2: g.drawImage(new Image("pics/sound_on.png"), buttonX, buttonY);
						break;
				case 3: g.drawImage(new Image("pics/music_on.png"), buttonX, buttonY);
						break;	
				case 4: g.drawImage(new Image("pics/controls.png"), buttonX, buttonY);
						break;
				case 5: g.drawImage(new Image("pics/exit_game.png"), buttonX, buttonY);
						break;
			}
			//increase Y with buttonHeight to place the buttons underneath each other
			buttonY = buttonY + buttonHeight;
		}
	}

	@Override
	/*Move marker if key is pressed down*/
	public void markButtonDown() {
		isMarked = ++isMarked % 6;
	}
	
	@Override
	/*Move marker if key is pressed up*/
	public void markButtonUp() {
		isMarked = (isMarked + 5) %6; //add 4 to make positive (--isMarked + 5)
	}

	public int getIsMarked() {
		return isMarked;
	}

}
