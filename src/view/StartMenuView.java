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
	private Image startGameLabel;
	private Image highscoreLabel;
	private Image soundOnLabel;
	private Image soundOffLabel;
	private Image musicOnLabel;
	private Image musicOffLabel;
	private Image controlsLabel;
	private Image exitGameLabel;
	

	public StartMenuView(StartMenu startMenu) throws SlickException {
		this.startMenu = startMenu;
		this.buttonWidth = Game.WINDOW_WIDTH;
		this.buttonHeight = (2*Game.WINDOW_HEIGHT)/15;
		buttonList = new ArrayList<Rectangle>();
		
		startGameLabel = new Image("pics/start_game.png");
		highscoreLabel = new Image("pics/highscore.png");
		soundOnLabel = new Image("pics/sound_on.png");
		soundOffLabel = new Image("pics/sound_off.png");
		musicOnLabel = new Image("pics/music_on.png");
		controlsLabel = new Image("pics/controls.png");
		exitGameLabel = new Image("pics/exit_game.png");
	}
	
	public void render(GameContainer gc, StateBasedGame game, Graphics g)
			throws SlickException {
		this.g = g;
		/*Add background and title, create buttons*/
		g.drawImage(new Image("pics/bluebg.png"), 0, 0);
		g.drawImage(new Image("pics/candy_monsters_orange.png"), 0, 0);
		createButtons(gc, g);
	}
	
	public void createButtons(GameContainer gc, Graphics g) throws SlickException {
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
				case 0: g.drawImage(startGameLabel, buttonX, buttonY);
						break;
				case 1: g.drawImage(highscoreLabel, buttonX, buttonY);
						break;
				case 2: g.drawImage(soundOnLabel, buttonX, buttonY);
						soundButtonX = buttonX;
						soundButtonY = buttonY;
						break;
				case 3: g.drawImage(musicOnLabel, buttonX, buttonY);
						musicButtonX = buttonX;
						musicButtonY = buttonY;
						break;	
				case 4: g.drawImage(controlsLabel, buttonX, buttonY);
						break;
				case 5: g.drawImage(exitGameLabel, buttonX, buttonY);
						break;
			}
			//increase Y with buttonHeight to place the buttons underneath each other
			buttonY = buttonY + buttonHeight;
		}
	}
	
	/*Turn sound on and change label on button*/
	public void soundOn() throws SlickException {
		startMenu.setIsSoundOff(false);
		soundOffLabel.destroy();
	}
	
	/*Turn sound off and change label on button*/
	public void soundOff() throws SlickException {
		startMenu.setIsSoundOff(true);
		g.drawImage(soundOffLabel, soundButtonX, soundButtonY);
	}
	
	public void musicOn() throws SlickException {
		startMenu.setIsMusicOff(false);
		musicOffLabel.destroy();
	}
	
	/*Turn music off and change label on button*/
	public void musicOff() throws SlickException {
		startMenu.setIsMusicOff(true);
		g.drawImage(musicOffLabel, musicButtonX, musicButtonY);
	}

}
