package view;		

import java.util.ArrayList;

import model.Game;
import model.StartMenu;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

public class StartMenuView extends AbstractMenuView {
	private StartMenu startMenu;
	private GameView gameView;
	private int buttonWidth;
	private int buttonHeight;
	private ArrayList<Rectangle> buttonList;

	public StartMenuView(StartMenu startMenu, GameView gameView) throws SlickException {
		this.startMenu = startMenu;
		this.gameView = gameView;
		this.buttonWidth = Game.WINDOW_WIDTH;
		this.buttonHeight = (2*Game.WINDOW_HEIGHT)/15;
		buttonList = new ArrayList<Rectangle>();
	}
	
	public void render(GameContainer gc, StateBasedGame game, Graphics g)
			throws SlickException {
		/*Add background and title, create buttons*/
		g.drawImage(super.getBackground(), 0, 0);
		g.drawImage(super.getCandyMonsterTitle(), 0, 0);
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
				g.setColor(new Color(0f, 0f, 0f, 0.7f));
				g.fill(buttonList.get(i));
			} else {
				g.setColor(new Color(0f, 0f, 0f, 0f));
				g.draw(buttonList.get(i));
			}
			/*Add labels to buttons*/
			switch(i) {
				case 0: g.drawImage(super.getStartGameLabel(), buttonX, buttonY);
						break;
						
				case 1: g.drawImage(super.getHighscoreLabel(), buttonX, buttonY);
						break;
						
				case 2: if(gameView.getGame().isSoundOn()){
							g.drawImage(super.getSoundOnLabel(), buttonX, buttonY);
						} else {
							g.drawImage(super.getSoundOffLabel(), buttonX, buttonY);
						}
						break;
						
				case 3: if(gameView.getGame().isMusicOn()){
							g.drawImage(super.getMusicOnLabel(), buttonX, buttonY);
						} else {
							g.drawImage(super.getMusicOffLabel(), buttonX, buttonY);
						}
						break;	
						
				case 4: g.drawImage(super.getControlsLabel(), buttonX, buttonY);
						break;
						
				case 5: g.drawImage(super.getExitGameLabel(), buttonX, buttonY);
						break;
			}
			//increase Y with buttonHeight to place the buttons underneath each other
			buttonY = buttonY + buttonHeight;
		}
	}
}