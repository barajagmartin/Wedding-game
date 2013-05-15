package controller;

import model.Game;
import model.InGame;
import model.PauseMenu;
import model.StartMenu;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import utils.MenuUtils;
import view.StartMenuView;

public class StartMenuController extends BasicGameState {
	private StartMenuView startMenuView;
	private StartMenu startMenu;
	private StateBasedGame sbg;
	private Graphics g;
	private GameController gameController;
	
	public StartMenuController(GameController gameController) {
		this.gameController = gameController;
	}
	
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		this.sbg = game;
		this.startMenu = new StartMenu();
		this.startMenuView = new StartMenuView(this.startMenu);

	}
	
	@Override
	public void enter(GameContainer container, StateBasedGame game) throws SlickException {
		super.enter(container, game);
		InGame.setNewGame(true);
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		this.g = g;
		this.startMenuView.render(container, game, g);
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}
	
	public void keyPressed (int key, char c) {
		if(key == Input.KEY_DOWN) {
			startMenu.markButtonDown();
		}
		if(key == Input.KEY_UP) {
			startMenu.markButtonUp();
		}
		if(key == Input.KEY_ENTER) {
			switch(startMenu.getIsMarked()){
				case 0: sbg.enterState(Game.IN_GAME);
						break;
				case 1: sbg.enterState(Game.HIGHSCORE);
						break;
				case 2: //Sound:: On/Off
						break;
				case 3: //Music: On/Off		
						break;
				case 4: //sbg.enterState(Game.CONTROLS);
						break;
				case 5: System.exit(0);
			}
		}
	}

	@Override
	public int getID() {
		return Game.START_MENU;
	}

}
