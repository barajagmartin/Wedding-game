package view;		

import java.util.ArrayList;

import model.Game;
import model.StartMenu;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

public class StartMenuView {
	private StartMenu startMenu;
	private int buttonWidth;
	private int buttonHeight;
	private int soundButtonX;
	private int soundButtonY;
	private int musicButtonX;
	private int musicButtonY;
	private ArrayList<Rectangle> buttonList;
	private Graphics g;
	/*Labels for buttons*/

	public StartMenuView(StartMenu startMenu) {
		this.startMenu = startMenu;
		this.buttonWidth = Game.WINDOW_WIDTH;
		this.buttonHeight = (2*Game.WINDOW_HEIGHT)/15;
		buttonList = new ArrayList<Rectangle>();
	}
	
	public void render(GameContainer gc, StateBasedGame game, Graphics g)
			throws SlickException {
		this.g = g;
		/*Add background and title, create buttons*/
		g.drawImage(new Image("pics/bluebg.png"), 0, 0);
		g.drawImage(new Image("pics/candy_monsters_orange.png"), 0, 0);
		createButtons(gc, g);
	}
	
	public void createButtons(GameContainer gc, Graphics g) throws SlickException{
		//start position
		int buttonX = 0;
		int buttonY = Game.WINDOW_HEIGHT/7;
		/*Add rectangles as buttons*/
		for(int i = 0; i < 6; i++){
			this.buttonList.add(new Rectangle(buttonX, buttonY, buttonWidth, buttonHeight));

			if(buttonList.indexOf(buttonList.get(i)) == startMenu.getIsMarked()) {
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
						soundButtonX = buttonX;
						soundButtonY = buttonY;
						break;
				case 3: g.drawImage(new Image("pics/music_on.png"), buttonX, buttonY);
						musicButtonX = buttonX;
						musicButtonY = buttonY;
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
	
	/*Turn sound off and change label on button*/
	public void soundOff() throws SlickException {
		startMenu.setIsSoundOff(true);
		g.drawImage(new Image("pics/sound_off.png"), soundButtonX, soundButtonY);
		
	}
	
	/*Turn music off and change label on button*/
	public void musicOff() throws SlickException {
		startMenu.setIsMusicOff(true);
		g.drawImage(new Image("pics/music_off.png"), musicButtonX, musicButtonY);
	}

}
