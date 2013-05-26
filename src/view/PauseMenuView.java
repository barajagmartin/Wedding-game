package view;

import java.util.ArrayList;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

import model.Game;
import model.PauseMenu;

public class PauseMenuView extends AbstractMenuView {
	private PauseMenu pauseMenu;
	private GameView gameView;
	private int buttonHeight;
	private int buttonWidth;
	private ArrayList<Rectangle> buttonList;

	public PauseMenuView(PauseMenu pauseMenu, GameView gameView) throws SlickException {
		this.pauseMenu = pauseMenu;
		this.gameView = gameView;
		this.buttonWidth = Game.WINDOW_WIDTH;
		this.buttonHeight = (2*Game.WINDOW_HEIGHT)/15;
		buttonList = new ArrayList<Rectangle>();
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		/*Draw illusion image of the game*/
		g.drawImage(gameView.getPauseImage(), 0, 0);
		
		/*Make background darker to highlight pause menu*/
		g.setColor(new Color(0f, 0f, 0f, 0.5f));
		g.fillRect(0, 0, Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT);
		
		createButtons(gc, g);
	}
	
	public void createButtons(GameContainer gc, Graphics g) throws SlickException {
		//start position
		int buttonX = 0;
		int buttonY = Game.WINDOW_HEIGHT/7;
		/*Create rectangles as buttons*/
		for(int i = 0; i < 5; i++){
			this.buttonList.add(new Rectangle(buttonX, buttonY, buttonWidth, buttonHeight));

			if(buttonList.indexOf(buttonList.get(i)) == pauseMenu.getIsMarked()) {
				g.setColor(new Color(0f, 0f, 0f, 0.8f));
				g.fill(buttonList.get(i));
			} else {
				g.setColor(new Color(0f, 0f, 0f, 0f));
				g.draw(buttonList.get(i));
			}
			/*Add labels to buttons*/
			switch(i) {
			case 0: g.drawImage(super.getResumeLabel(), buttonX, buttonY);
					break;
			
			case 1: if(gameView.getGame().isSoundOn()){
						g.drawImage(super.getSoundOnLabel(), buttonX, buttonY);
					} else {
						g.drawImage(super.getSoundOffLabel(), buttonX, buttonY);
					}
					break;
					
			case 2: if(gameView.getGame().isMusicOn()){
						g.drawImage(super.getMusicOnLabel(), buttonX, buttonY);
					} else {
						g.drawImage(super.getMusicOffLabel(), buttonX, buttonY);
					}
					break;
					
			case 3: g.drawImage(super.getControlsLabel(), buttonX, buttonY);
					break;
					
			case 4: g.drawImage(super.getExitToMenuLabel(), buttonX, buttonY);
					break;
			}

			//increase Y with buttonHeight to place the buttons underneath each other
			buttonY = buttonY + buttonHeight;
		}
	}
}